package dietbisabesok.com.bukanitip.di.module;

import com.google.gson.Gson;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import dietbisabesok.com.bukanitip.BuildConfig;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllCountryListService;
import dietbisabesok.com.bukanitip.activity.login.service.LoginService;
import dietbisabesok.com.bukanitip.activity.login.service.UpdateUserService;
import dietbisabesok.com.bukanitip.di.scope.ApplicationScope;
import dietbisabesok.com.bukanitip.network.NetworkService;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */
@Module
public class NetworkModule {
    File cacheFile;

    public NetworkModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    @Provides
    @ApplicationScope
    Retrofit provideCall() {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024); //10MiB
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();

                    // Customize the request
                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .removeHeader("Pragma")
                            .header("Cache-Control", String.format("max-age=%d", BuildConfig.CACHETIME))
                            .build();

                    okhttp3.Response response = chain.proceed(request);
                    response.cacheResponse();
                    // Customize or return the response
                    return response;
                })
                .writeTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .connectTimeout(90, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();


        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    @Provides
    @ApplicationScope
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @ApplicationScope
    public NetworkService providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @ApplicationScope
    public LoginService providesService(
            NetworkService networkService) {
        return new LoginService(networkService);
    }

    @Provides
    @ApplicationScope
    public UpdateUserService provideUpdateUserService(
            NetworkService networkService) {
        return new UpdateUserService(networkService);
    }

    @Provides
    @ApplicationScope
    public FetchAllCountryListService provideFetchAllCountryListService(
            NetworkService networkService) {
        return new FetchAllCountryListService(networkService);
    }
//
//    @Provides
//    @ApplicationScope
//    public GetUserClassExamScheduleService provideGetUserClassExamScheduleService(
//            NetworkService networkService) {
//        return new GetUserClassExamScheduleService(networkService);
//    }
//
//    @Provides
//    @ApplicationScope
//    public GetUserClassScheduleService proviGetUserClassScheduleService(
//            NetworkService networkService) {
//        return new GetUserClassScheduleService(networkService);
//    }
//
//    @Provides
//    @ApplicationScope
//    public GetUserLectureScheduleService proGetUserLectureScheduleService(
//            NetworkService networkService) {
//        return new GetUserLectureScheduleService(networkService);
//    }
//
//    @Provides
//    @ApplicationScope
//    public FetchCalendarAcademicService provideFetchCalendarAcademicService(
//            NetworkService networkService) {
//        return new FetchCalendarAcademicService(networkService);
//    }
//
//    @Provides
//    @ApplicationScope
//    public FetchUserGradePointService provideFetchUserGradePointService(
//            NetworkService networkService) {
//        return new FetchUserGradePointService(networkService);
//    }
//
//    @Provides
//    @ApplicationScope
//    public FetchNewsService provideFetchNewsService(
//            NetworkService networkService) {
//        return new FetchNewsService(networkService);
//    }
//
//    @Provides
//    @ApplicationScope
//    public DetailNewsService provideDetailNewsService(
//            NetworkService networkService) {
//        return new DetailNewsService(networkService);
//    }

}
