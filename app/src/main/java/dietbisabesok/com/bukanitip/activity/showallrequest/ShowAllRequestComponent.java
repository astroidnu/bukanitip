package dietbisabesok.com.bukanitip.activity.showallrequest;

import dagger.Component;
import dietbisabesok.com.bukanitip.activity.showallcountry.ShowAllCountriesScope;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@ShowAllRequestScope
@Component(dependencies = {AppComponent.class})
public interface ShowAllRequestComponent {
    void inject(ShowAllRequestPresenter mPresenter);
    void inject(ShowAllRequestActivity showAllRequestActivity);
}
