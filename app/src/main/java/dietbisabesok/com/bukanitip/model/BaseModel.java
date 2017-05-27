package dietbisabesok.com.bukanitip.model;

import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.data.DaoSession;
import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class BaseModel {
    protected final DaoSession mDaoSession;
    protected final AppComponent mComponent;

    public BaseModel(BukaNitipApp app, DaoSession daoSession) {
        mComponent = app.component();
        mDaoSession = daoSession;
    }
}
