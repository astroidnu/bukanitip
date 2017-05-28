package dietbisabesok.com.bukanitip.activity.listoffering;

import dagger.Component;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@ListOfferingScope
@Component(dependencies = {AppComponent.class})
public interface ListOfferingComponent {
    void inject(ListOfferingPresenter mPresenter);

    void inject(ListOfferingActivity activity);
}
