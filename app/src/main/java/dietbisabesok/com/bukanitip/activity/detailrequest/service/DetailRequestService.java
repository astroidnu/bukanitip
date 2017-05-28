package dietbisabesok.com.bukanitip.activity.detailrequest.service;

import java.util.HashMap;

import dietbisabesok.com.bukanitip.helper.AppConst;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.network.NetworkService;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class DetailRequestService {
    private final NetworkService networkService;
    private HashMap<String, String> mParam;
    public void init(HashMap<String, String> param){
        mParam = param;
    }

    public DetailRequestService(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription fetchDetailRequest(final GetResponseCallback callback) {
        return networkService.getDetailRequest(AppConst.base_url.TAG_LOCAL_BASE_URL+"Titipan/detail_titipan",mParam)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.error(throwable);
                })
                        .subscribe(new Observer<DetailRequestResponse>() {
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
                    public void onNext(DetailRequestResponse dataList) {
                        try{
                            callback.onSuccess(dataList);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                });
    }
    public interface GetResponseCallback{
        void onSuccess(DetailRequestResponse dataList);
        void onError(NetworkError networkError);
    }
}
