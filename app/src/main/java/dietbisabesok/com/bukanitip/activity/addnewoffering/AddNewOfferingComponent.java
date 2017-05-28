package dietbisabesok.com.bukanitip.activity.addnewoffering;

import dagger.Component;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@AddNewOfferingScope
@Component(dependencies = {AppComponent.class})
public interface AddNewOfferingComponent {
    void inject(AddNewOfferingPresenter mPresenter);
    void inject(AddNewOfferingActivity addNewOfferingActivity);
}
