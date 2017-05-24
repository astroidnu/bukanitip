package dietbisabesok.com.bukanitip.ui.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

public class ActivityScreenSwitcher implements ScreenSwitcher {

    private WeakReference<Activity> mActivityWeakReference;

    public void attach(Activity activity){
        mActivityWeakReference = new WeakReference<Activity>(activity);
    }

    @Override
    public void open(Screen screen) {
        final Activity activity = getAttachedActivity();
        if (activity == null) {
            return;
        }
        if (screen instanceof ActivityScreen) {
            ActivityScreen activityScreen = ((ActivityScreen) screen);
            Intent intent = activityScreen.intent(activity);
            ActivityCompat
                    .startActivity(activity, intent, activityScreen.activityOptions(activity));
        } else {
            throw new InvalidParameterException("Only ActivityScreen objects allowed");
        }
    }

    @Override
    public void goBack() {
        final Activity activity = getAttachedActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override
    public void openAndFinish(Screen screen) {
        final Activity activity = getAttachedActivity();
        open(screen);
        if (activity != null) {
            activity.finish();
        }
    }

    public void startForResult(int requestCode, Screen screen) {
        final Activity activity = getAttachedActivity();
        if (activity != null && screen instanceof ActivityScreen) {
            ActivityScreen activityScreen = ((ActivityScreen) screen);
            Intent intent = activityScreen.intent(activity);
            activity.startActivityForResult(intent, requestCode);
        } else {
            throw new InvalidParameterException("Only ActivityScreen objects allowed");
        }
    }

    @Override
    public void closeWithResult(int resultCode, Intent result) {
        final Activity activity = getAttachedActivity();
        if (activity != null) {
            activity.setResult(resultCode, result);
            activity.finish();
        }
    }


    public Activity getAttachedActivity(){
        return mActivityWeakReference.get();
    }

}
