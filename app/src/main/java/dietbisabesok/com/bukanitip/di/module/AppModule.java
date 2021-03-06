package dietbisabesok.com.bukanitip.di.module;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.di.DependencyInjector;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.data.DaoMaster;
import dietbisabesok.com.bukanitip.data.DaoSession;
import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.di.scope.ApplicationScope;
import dietbisabesok.com.bukanitip.helper.AppConst;
import dietbisabesok.com.bukanitip.job.BaseJob;
import dietbisabesok.com.bukanitip.model.CountryDataModel;
import dietbisabesok.com.bukanitip.model.RequestDataModel;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */

@Module
public class AppModule {
    private final BukaNitipApp mApp;

    public AppModule(BukaNitipApp app){ this.mApp = app; }

    @Provides
    @ApplicationScope
    Application provideApplicationContext(){ return mApp; }

//    @Provides
//    @ApplicationScope
//    JobManager provideJobManager() {
//        Configuration config = new Configuration.Builder(mApp)
//                .minConsumerCount(10)
//                .consumerKeepAlive(45)
//                .injector(new DependencyInjector() {
//                    @Override
//                    public void inject(Job job) {
//                        if (job instanceof BaseJob) {
//                            ((BaseJob) job).inject(mApp.component());
//                        }
//                    }
//                })
//                .build();
//        return new JobManager(mApp, config);
//    }

    @Provides
    @ApplicationScope
    EventBus getEventBus() {
        return new EventBus();
    }

    @Provides
    @ApplicationScope
    DaoSession provideDaoSession() {
        String DbName = AppConst.database_name.TAG_DATABASE_NAME;
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BukaNitipApp.getApp(), DbName);
        Log.d("New DB Name: ", DbName);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        Log.d("Schema DB" , String.valueOf(daoMaster.getSchemaVersion()));
        return daoMaster.newSession();
    }
//
//    @Provides
//    @ApplicationScope
//    LocalState provideLocalState() {
//        return new LocalState();
//    }
//
    @Provides
    @ApplicationScope
    CountryDataModel provideCountryDataModel(DaoSession daoSession) {
        return new CountryDataModel(mApp, daoSession);
    }

    @Provides
    @ApplicationScope
    RequestDataModel provideRequestDataModel(DaoSession daoSession) {
        return new RequestDataModel(mApp, daoSession);
    }
//
//    @Provides
//    @ApplicationScope
//    UserGradePointModel provideUserGradePointModel(DaoSession daoSession) {
//        return new UserGradePointModel(mApp, daoSession);
//    }
//
//    @Provides
//    @ApplicationScope
//    DetailGradePointModel provideDetailGradePointModel(DaoSession daoSession) {
//        return new DetailGradePointModel(mApp, daoSession);
//    }
//
//    @Provides
//    @ApplicationScope
//    CalendarAcademicModel provideCalendarAcademicModel(DaoSession daoSession) {
//        return new CalendarAcademicModel(mApp, daoSession);
//    }
//
//    @Provides
//    @ApplicationScope
//    public ScheduleController provideScheduleController() {
//        return new ScheduleController(mApp.component());
//    }
//
//    @Provides
//    @ApplicationScope
//    public FetchGradePointController provideFetchGradePointController(){
//        return new FetchGradePointController((mApp.component()));
//    }
}
