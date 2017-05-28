package dietbisabesok.com.bukanitip.activity.addnewoffering;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.HashMap;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.activity.addnewoffering.service.AddOfferingResponse;
import dietbisabesok.com.bukanitip.activity.addnewoffering.service.AddOfferingService;
import dietbisabesok.com.bukanitip.data.AddOfferingData;
import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.session.LoginSession;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class AddNewOfferingPresenter extends ViewPresenter<AddNewOfferingView> {
    @Inject
    AddOfferingService mAddOfferingService;

    @Inject
    LoginSession mLoginSession;

    @Inject
    Gson gson;

    private AddNewOfferingActivity mActivity;
    private RequestData mRequestData;

    public AddNewOfferingPresenter(AddNewOfferingActivity addNewOfferingActivity, RequestData requestData) {
        mActivity = addNewOfferingActivity;
        mRequestData = requestData;

    }

    @Override
    public void onLoad(){
        super.onLoad();
        onFinishActivity();
        getView().mOfferingSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewOffering();
            }
        });
    }

    private void onFinishActivity() {
        getView().mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }


    private void addNewOffering(){
        getView().mProgressDialog.show();
        AddOfferingData addOfferingData = new AddOfferingData();
        addOfferingData.setDay_estimation(Integer.parseInt(getView().mOfferingDayEstimation.getText().toString()));
        addOfferingData.setDescription(getView().mOfferingDescription.getText().toString());
        addOfferingData.setPrice(Integer.parseInt(getView().mOfferingPrice.getText().toString()));
        HashMap<String, String> mParam = new HashMap<>();
        mParam.put("token",mLoginSession.getLoginToken());
        mParam.put("email", mLoginSession.getEmail());
        mParam.put("user_id", mLoginSession.getUserID());
        mParam.put("data", gson.toJson(addOfferingData));
        mParam.put("request_nitip_id", String.valueOf(mRequestData.id));
        Log.d(getClass().getName(), gson.toJson(mParam));
        mAddOfferingService.init(mParam);
        mAddOfferingService.postNewOffering(new AddOfferingService.GetResponseCallback() {
            @Override
            public void onSuccess(AddOfferingResponse dataList) {
                getView().mProgressDialog.hide();
                getView().setToastMsg(dataList.message);
                if(!dataList.status.equals("ERROR")){
                    mActivity.finish();
                }
            }

            @Override
            public void onError(NetworkError networkError) {
                getView().mProgressDialog.hide();
                getView().setToastMsg(networkError.getMessage());
            }
        });
    }
}
