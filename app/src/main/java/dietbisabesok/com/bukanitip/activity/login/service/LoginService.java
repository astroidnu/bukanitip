package dietbisabesok.com.bukanitip.activity.login.service;

import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.network.NetworkService;
import okhttp3.Credentials;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class LoginService {
    private final NetworkService networkService;
    private String mUsername;
    private String mPassword;

    public void init(String username, String password){
        mUsername = username;
        mPassword = password;
    }

    public LoginService(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription userLogin(final GetResponseCallback callback) {
        return networkService.userLogin(Credentials.basic(mUsername,mPassword))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.error(throwable);
                })
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        try{
                            callback.onError(new NetworkError(e));
                        }catch (Exception err){
                            err.printStackTrace();
                        }

                    }
                    @Override
                    public void onNext(LoginResponse dataList) {
                        try{
                            callback.onSuccess(dataList);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                });
    }
    public interface GetResponseCallback{
        void onSuccess(LoginResponse dataList);
        void onError(NetworkError networkError);
    }
}
