package dietbisabesok.com.bukanitip.activity.listoffering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.base.BaseActivity;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreen;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ListOfferingActivity extends BaseActivity {
    private ListOfferingComponent mComponent;
    private ListOfferingView mView;
    private ListOfferingPresenter mPresenter;
    @Override
    protected void onCreateUI(Bundle bundle) {
        mView = ListOfferingView_.build(this);
        setContentView(mView);
        mPresenter = new ListOfferingPresenter(this);
        mComponent.inject(mPresenter);
        mPresenter.takeView(mView);
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerListOfferingComponent.builder().appComponent(appComponent).build();
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

        public Screen() {

        }

        @Override
        protected void configureIntent(@NonNull Intent intent) {

        }

        @Override
        protected Class<? extends Activity> activityClass() {
            return ListOfferingActivity.class;
        }
    }
}
