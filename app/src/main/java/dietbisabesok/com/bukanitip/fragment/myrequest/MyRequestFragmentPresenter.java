package dietbisabesok.com.bukanitip.fragment.myrequest;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.StringJoiner;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.fragment.myrequest.service.MyRequestService;
import dietbisabesok.com.bukanitip.fragment.myrequest.service.MyRequestServiceResponse;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.session.LoginSession;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class MyRequestFragmentPresenter extends ViewPresenter<MyRequestFragmentView> {
    @Inject
    MyRequestService myRequestService;

    @Inject
    LoginSession mLoginSession;

    @Inject
    Gson gson;

    private MyRequestFragment mMyRequestFragment;

    public MyRequestFragmentPresenter(MyRequestFragment myRequestFragment){
        mMyRequestFragment = myRequestFragment;
    }

    @Override
    public void onLoad(){
        super.onLoad();
        myRequestService();
    }

    private void myRequestService(){
        HashMap<String, String> mParam = new HashMap<>();
        mParam.put("user_id", mLoginSession.getUserID());
        mParam.put("token", mLoginSession.getLoginToken());
        mParam.put("email", mLoginSession.getEmail());
        myRequestService.init(mParam);
        myRequestService.getMyRequestList(new MyRequestService.GetResponseCallback() {
            @Override
            public void onSuccess(MyRequestServiceResponse dataList) {
                Log.d(getClass().getName(),gson.toJson(dataList));
            }

            @Override
            public void onError(NetworkError networkError) {
                Log.e(getClass().getName(),networkError.getMessage());
            }
        });
    }
}
