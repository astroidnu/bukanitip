package dietbisabesok.com.bukanitip.activity.addnewrequest;

import dagger.Component;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */
@AddNewRequestScope
@Component(dependencies = {AppComponent.class})
public interface AddNewRequestComponent {
    void inject(AddNewRequestPresenter mPresenter);
    void inject(AddNewRequestActivity addNewRequestActivity);
}
