package dietbisabesok.com.bukanitip.activity.home.service;

import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.network.NetworkService;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class FetchDetailUserService {
    private final NetworkService networkService;
    private String mUserID;

    public void init(String userid){
        mUserID = userid;
    }

    public FetchDetailUserService(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription userLogin(final GetResponseCallback callback) {
        return networkService.userInfo(mUserID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.error(throwable);
                })
                .subscribe(new Observer<FetchDetailUserResponse>() {
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
                    public void onNext(FetchDetailUserResponse dataList) {
                        try{
                            callback.onSuccess(dataList);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                });
    }
    public interface GetResponseCallback{
        void onSuccess(FetchDetailUserResponse dataList);
        void onError(NetworkError networkError);
    }
}
