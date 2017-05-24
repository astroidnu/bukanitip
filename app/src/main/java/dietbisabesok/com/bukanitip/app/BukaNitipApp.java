package dietbisabesok.com.bukanitip.app;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.squareup.leakcanary.LeakCanary;

import dietbisabesok.com.bukanitip.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */

public class BukaNitipApp extends MultiDexApplication{
    private static BukaNitipApp mInstance;

    private AppComponent mAppComponent;

    public static BukaNitipApp getApp(){ return mInstance; }

    @Override
    public void onCreate(){
        super.onCreate();

        MultiDex.install(this);

        mInstance = this;
        mAppComponent = AppComponent.Initializer.init(this);

        LeakCanary.install(this);

//        CalligraphyConfig.initDefault(
//                new CalligraphyConfig.Builder()
//                        .setDefaultFontPath("fonts/calibri.ttf")
//                        .setFontAttrId(R.attr.fontPath)
//                        .build()
//        );
    }


    public AppComponent component(){ return mAppComponent;}
}
