package dietbisabesok.com.bukanitip.di.component;

import android.app.Application;

import java.io.File;

import dagger.Component;
import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.di.module.AppModule;
import dietbisabesok.com.bukanitip.di.module.AppUIModule;
import dietbisabesok.com.bukanitip.di.module.NetworkModule;
import dietbisabesok.com.bukanitip.di.module.UserModule;
import dietbisabesok.com.bukanitip.di.scope.ApplicationScope;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */

@ApplicationScope
@Component(
        modules = {AppModule.class, AppUIModule.class, NetworkModule.class, UserModule.class}
)
public interface AppComponent extends IAppComponent {

    final static class Initializer {
        public static AppComponent init(BukaNitipApp app){
            File cacheFile = new File(app.getCacheDir(), "responses");
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }
    }

    Application getApplication();
}
