package dietbisabesok.com.bukanitip.activity.detailcountry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.base.BaseActivity;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreen;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class DetailCountryActivity extends BaseActivity {

    private DetailCountryComponent mComponent;
    private DetailCountryPresenter mPresenter;
    private DetailCountryView mView;
    @Override
    protected void onCreateUI(Bundle bundle) {
        mView = DetailCountryView_.build(this);
        setContentView(mView);
        CountryData countryData = getIntent().getParcelableExtra("data");
        mPresenter = new DetailCountryPresenter(this,countryData);
        mComponent.inject(mPresenter);
        mPresenter.takeView(mView);
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerDetailCountryComponent.builder().appComponent(appComponent).build();
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
            return DetailCountryActivity.class;
        }
    }
}
