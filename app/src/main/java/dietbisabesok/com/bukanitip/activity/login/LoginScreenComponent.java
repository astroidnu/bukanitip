package dietbisabesok.com.bukanitip.activity.login;

import dagger.Component;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.di.module.NetworkModule;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */
@LoginScreenScope
@Component(dependencies = {AppComponent.class})
public interface LoginScreenComponent {
    void inject(LoginScreenPresenter mPresenter);
    void inject(LoginScreenActivity loginScreenActivity);
}
