package dietbisabesok.com.bukanitip.model;

import android.support.annotation.Nullable;

import java.util.List;

import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.data.DaoSession;
import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.data.RequestDataDao;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class RequestDataModel extends BaseModel {
    RequestDataDao mEntityDao;

    public RequestDataModel(BukaNitipApp app, DaoSession daoSession) {
        super(app, daoSession);
        app.component().inject(this);
        mEntityDao = daoSession.getRequestDataDao();
    }

    @Nullable
    public List<RequestData> loadAll() {
        return mEntityDao.loadAll();
    }

    @Nullable
    public List<RequestData> loadAllTrendRequest() {
        return mEntityDao.queryBuilder().where(RequestDataDao.Properties.Trending.eq(1))
                .orderAsc(RequestDataDao.Properties.Title).list();

    }

    public void save(RequestData requestData) {
        mEntityDao.insertOrReplace(requestData);
    }

    public void clear() {
        mEntityDao.deleteAll();
    }
}
