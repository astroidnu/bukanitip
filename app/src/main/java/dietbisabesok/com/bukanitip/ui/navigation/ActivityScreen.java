package dietbisabesok.com.bukanitip.ui.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;

public abstract class ActivityScreen implements Screen {

    private static final String BF_TRANSITION_VIEW = "ImgurImageActivity.transitionView";

    @Nullable
    private View transitionView;
    private String transitionName;

    public void attachTransitionView(@Nullable View view, String name) {
        transitionView = view;
        transitionName = name;
    }

    @Nullable
    protected View detachTransitionView() {
        View view = transitionView;
        transitionView = null;
        return view;
    }

    @NonNull
    public final Intent intent(Context context) {
        Intent intent = new Intent(context, activityClass());
        configureIntent(intent);
        return intent;
    }

    protected final Bundle activityOptions(Activity activity) {
        View transitionView = detachTransitionView();
        if (transitionView == null) {
            return null;
        }
        return ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity, transitionView, transitionName)
                .toBundle();
    }

    protected abstract void configureIntent(@NonNull Intent intent);

    protected abstract Class<? extends Activity> activityClass();

    public static void setTransitionView(View view) {
        ViewCompat.setTransitionName(view, BF_TRANSITION_VIEW);
    }

}
