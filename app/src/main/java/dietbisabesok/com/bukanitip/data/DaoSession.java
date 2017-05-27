package dietbisabesok.com.bukanitip.data;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import dietbisabesok.com.bukanitip.data.CountryData;

import dietbisabesok.com.bukanitip.data.CountryDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig countryDataDaoConfig;

    private final CountryDataDao countryDataDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        countryDataDaoConfig = daoConfigMap.get(CountryDataDao.class).clone();
        countryDataDaoConfig.initIdentityScope(type);

        countryDataDao = new CountryDataDao(countryDataDaoConfig, this);

        registerDao(CountryData.class, countryDataDao);
    }
    
    public void clear() {
        countryDataDaoConfig.clearIdentityScope();
    }

    public CountryDataDao getCountryDataDao() {
        return countryDataDao;
    }

}
