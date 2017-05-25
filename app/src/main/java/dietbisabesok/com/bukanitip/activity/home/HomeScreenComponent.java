package dietbisabesok.com.bukanitip.activity.home;

import dagger.Component;
import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.fragment.home.HomeFragment;
import dietbisabesok.com.bukanitip.fragment.home.HomeFragmentPresenter;
import dietbisabesok.com.bukanitip.fragment.profile.ProfileFragment;
import dietbisabesok.com.bukanitip.fragment.profile.ProfileFragmentPresenter;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */
@HomeScreenScope
@Component(dependencies = {AppComponent.class})
public interface HomeScreenComponent {
    void inject(HomeScreenPresenter mPresenter);
    void inject(HomeScreenActivity homeScreenActivity);
    void inject(ProfileFragment profileFragment);
    void inject(HomeFragment homeFragment);
    void inject(ProfileFragmentPresenter mPresenter);
    void inject(HomeFragmentPresenter mPresenter);
}
