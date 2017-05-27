package dietbisabesok.com.bukanitip.model;

import android.support.annotation.Nullable;

import java.util.List;

import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.data.CountryDataDao;
import dietbisabesok.com.bukanitip.data.DaoSession;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class CountryDataModel extends BaseModel {
    CountryDataDao mEntityDao;

    public CountryDataModel(BukaNitipApp app, DaoSession daoSession) {
        super(app, daoSession);
        app.component().inject(this);
        mEntityDao = daoSession.getCountryDataDao();
    }

    @Nullable
    public List<CountryData> loadAll() {
        return mEntityDao.loadAll();
    }

    @Nullable
    public List<CountryData> loadTrendyCountryData(){
        return mEntityDao.queryBuilder().where(CountryDataDao.Properties.Favorite.eq(1))
                .orderAsc(CountryDataDao.Properties.Name).list();
    }

    public void clear() {
        mEntityDao.deleteAll();
    }

}
