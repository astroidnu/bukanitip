package dietbisabesok.com.bukanitip.activity.addnewoffering.service;

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

public class AddOfferingService {
    private final NetworkService networkService;
    private HashMap<String, String> mParam;
    public void init(HashMap<String, String> param){
        mParam = param;
    }

    public AddOfferingService(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription postNewOffering(final GetResponseCallback callback) {
        return networkService.postOffering(AppConst.base_url.TAG_LOCAL_BASE_URL+"Offering/offer_nitip",mParam)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.error(throwable);
                })
                .subscribe(new Observer<AddOfferingResponse>() {
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
                    public void onNext(AddOfferingResponse dataList) {
                        try{
                            callback.onSuccess(dataList);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                });
    }
    public interface GetResponseCallback{
        void onSuccess(AddOfferingResponse dataList);
        void onError(NetworkError networkError);
    }
}
