package dietbisabesok.com.bukanitip.activity.detailcountry;

import dagger.Component;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@DetailCountryScope
@Component(dependencies = {AppComponent.class})
public interface DetailCountryComponent {
    void inject(DetailCountryActivity activity);
    void inject(DetailCountryPresenter mPresenter);
}
