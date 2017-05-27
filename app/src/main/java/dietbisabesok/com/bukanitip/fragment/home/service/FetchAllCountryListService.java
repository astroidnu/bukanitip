package dietbisabesok.com.bukanitip.fragment.home.service;

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
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class FetchAllCountryListService {
    private final NetworkService networkService;
    private HashMap<String, String> mParam;
    public void init(HashMap<String, String> param){
        mParam = param;
    }

    public FetchAllCountryListService(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription fetchAllCountries(final GetResponseCallback callback) {
        return networkService.getCountries(AppConst.base_url.TAG_LOCAL_BASE_URL+"General/list_country",mParam)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.error(throwable);
                })
                .subscribe(new Observer<FetchAllCountryResponse>() {
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
                    public void onNext(FetchAllCountryResponse dataList) {
                        try{
                            callback.onSuccess(dataList);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                });
    }
    public interface GetResponseCallback{
        void onSuccess(FetchAllCountryResponse dataList);
        void onError(NetworkError networkError);
    }
}
