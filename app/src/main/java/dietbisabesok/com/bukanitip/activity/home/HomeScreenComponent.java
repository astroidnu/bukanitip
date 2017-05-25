package dietbisabesok.com.bukanitip.activity.home;

import dagger.Component;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */
@HomeScreenScope
@Component(dependencies = {AppComponent.class})
public interface HomeScreenComponent {
    void inject(HomeScreenPresenter mPresenter);
    void inject(HomeScreenActivity homeScreenActivity);
}
