package dietbisabesok.com.bukanitip.activity.login;


import android.os.Bundle;
import android.view.View;

import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.ui.base.BaseActivity;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

public class LoginScreenActivity extends BaseActivity {

    private LoginScreenComponent mComponent;
    private LoginScreenView mView;
    private LoginScreenPresenter mPresenter;

    @Override
    protected void onCreateUI(Bundle bundle) {
        mView = LoginScreenView_.build(this);
        setContentView(mView);
        mPresenter = new LoginScreenPresenter(this);
        mComponent.inject(mPresenter);
        mPresenter.takeView(mView);
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerLoginScreenComponent.builder().appComponent(appComponent).build();
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
}
