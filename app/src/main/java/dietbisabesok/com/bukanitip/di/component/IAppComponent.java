package dietbisabesok.com.bukanitip.di.component;


import dietbisabesok.com.bukanitip.app.BukaNitipApp;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreenSwitcher;

/**
 * Created by Ibnu Muzzakkir on 11/9/2016.
 * Contact ibnumuzzaakkir@gmail.com
 * scoproject
 */
public interface IAppComponent {

    void inject(BukaNitipApp app);

    ActivityScreenSwitcher activityScreenSwitcher();

}
