package dietbisabesok.com.bukanitip.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;


import java.lang.ref.WeakReference;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreenSwitcher;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Application activity base
 *
 * @author zhaocong
 */
public abstract class BaseActivity extends AppCompatActivity {

    private WeakReference<IScreenView> mContentView;
    private boolean isActivityVisible;
    private SparseArray<ResultCallback> mResultCallbacks;

    @Inject
    ActivityScreenSwitcher activityScreenSwitcher;
//
//    @Inject
//    protected CookieManager cookieManager;

    protected abstract void onCreateUI(Bundle bundle);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateComponent(BukaNitipApp.getApp().component());
        if (activityScreenSwitcher == null) {
            throw new IllegalStateException(
                    "No injection happened. Add component.inject(this) in onCreateComponent() implementation.");
        }
        activityScreenSwitcher.attach(this);
        onCreateUI(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (presenter() != null) {
            presenter().onRestore(savedInstanceState);
        }
    }

    /**
     * Implement this method to inject the dependency for activity
     *
     * @param appComponent the base app component
     */
    protected abstract void onCreateComponent(AppComponent appComponent);

    @Override
    public void setContentView(View view) {
        if (view instanceof IScreenView) {
            IScreenView evt = (IScreenView) view;
            mContentView = new WeakReference<>(evt);
        }
        super.setContentView(view);
    }

    /**
     * Override this method if the activity is excluded from passcode protection
     *
     * @return true if the current activity is protected by passcode
     */
    protected boolean passcodeProtected() {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mContentView != null && isValid()) {
            IScreenView evt = mContentView.get();
            if (evt != null) {
                evt.onShowView();
            }
        }
        if (presenter() != null) {
            presenter().onResume();
        }
        isActivityVisible = true;
        //re-enforce
        activityScreenSwitcher.attach(this);
        //BBAppStateManager.getInstance().setAppActive(true);

//        if (mSession.getLoginError() != null) {
//            resolveError(mSession.getLoginError());
//            mSession.setLoginError(null);
//        }
    }

    public boolean isActivityVisible() {
        return isActivityVisible;
    }

    @Override
    protected void onPause() {
        if (mContentView != null && isValid()) {
            IScreenView evt = mContentView.get();
            if (evt != null) {
                evt.onHideView();
            }
        }
        if (presenter() != null) {
            presenter().onPause();
        }
        super.onPause();
        isActivityVisible = false;
        //BBAppStateManager.getInstance().setAppActive(false);
    }

    /**
     * mark the activity state
     *
     * @return true if the activity instance is still functional
     */
    protected abstract boolean isValid();

    /**
     * Override this to initialize the base view presenter
     *
     * @return @link(ViewPresenter)
     */
    protected ViewPresenter<? extends View> presenter() {
        return null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter() != null) {
            presenter().onSave(outState);
        }
    }

    @Override
    protected void onDestroy() {
        if (mContentView != null) {
            IScreenView evt = mContentView.get();
            if (evt != null) {
                evt.onDestroy();
            }
            mContentView = null;
        }
        super.onDestroy();
    }

    public void onBack() {
        finish();
    }

    @Override
    @Deprecated
    public void onBackPressed() {
        onBack();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        activityScreenSwitcher.attach(this);
        if (mResultCallbacks != null) {
            ResultCallback callback = mResultCallbacks.get(requestCode);
            if (callback != null) {
                callback.onResult(resultCode, data);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (presenter() != null) {
            presenter().onActivityResult(requestCode, resultCode, data);
        }
    }

    protected void finishActivityWithTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            finish();
        }
    }

    public void registerForResultCallback(int requestCode, ResultCallback callback) {
        if (mResultCallbacks == null) {
            mResultCallbacks = new SparseArray<>();
        }
        mResultCallbacks.put(requestCode, callback);
    }

    public interface ResultCallback {
        public void onResult(int resultCode, Intent data);
    }

    private long mLastClickTime = 0;

    private static final long MIN_CLICK_INTERVAL = 1000;

    protected boolean isClickable() {
        return SystemClock.elapsedRealtime() - mLastClickTime > MIN_CLICK_INTERVAL;
    }

    protected void setLastClickTime() {
        mLastClickTime = SystemClock.elapsedRealtime();
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }
}
