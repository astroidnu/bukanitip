package dietbisabesok.com.bukanitip.activity.addnewoffering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.base.BaseActivity;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreen;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class AddNewOfferingActivity extends BaseActivity {
    private AddNewOfferingComponent mComponent;
    private AddNewOfferingPresenter mPresenter;
    private AddNewOfferingView mView;


    @Override
    protected void onCreateUI(Bundle bundle) {
        mView = AddNewOfferingView_.build(this);
        setContentView(mView);
        RequestData requestData = getIntent().getParcelableExtra(Screen.TAG_DATA);
        mPresenter = new AddNewOfferingPresenter(this,requestData);
        mComponent.inject(mPresenter);
        mPresenter.takeView(mView);
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerAddNewOfferingComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }

    @Override
    protected boolean isValid() {
        return false;
    }

    @Override
    protected ViewPresenter<? extends View> presenter() {
        return mPresenter;
    }

    public static class Screen extends ActivityScreen {
        public final static String TAG_DATA = "data";
        private RequestData mRequestData;
        public Screen(RequestData requestData) {
            mRequestData = requestData;
        }

        @Override
        protected void configureIntent(@NonNull Intent intent) {
            intent.putExtra(TAG_DATA, mRequestData);
        }

        @Override
        protected Class<? extends Activity> activityClass() {
            return AddNewOfferingActivity.class;
        }
    }
}
