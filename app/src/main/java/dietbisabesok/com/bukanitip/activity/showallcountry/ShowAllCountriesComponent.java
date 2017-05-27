package dietbisabesok.com.bukanitip.activity.showallcountry;

import dagger.Component;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */
@ShowAllCountriesScope
@Component(dependencies = {AppComponent.class})
public interface ShowAllCountriesComponent {
    void inject(ShowAllCountriesPresenter mPresenter);
    void inject(ShowAllCountriesActivity activity);
}
