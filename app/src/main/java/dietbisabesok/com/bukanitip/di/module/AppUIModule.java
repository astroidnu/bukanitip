package dietbisabesok.com.bukanitip.di.module;

import dagger.Module;
import dagger.Provides;
import dietbisabesok.com.bukanitip.di.scope.ApplicationScope;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreenSwitcher;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */

@Module
public class AppUIModule{
    @Provides
    @ApplicationScope
    ActivityScreenSwitcher provideActivityScreenSwitcher() {
        return new ActivityScreenSwitcher();
    }

}

