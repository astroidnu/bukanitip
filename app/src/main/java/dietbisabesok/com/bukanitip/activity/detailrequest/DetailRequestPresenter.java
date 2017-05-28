package dietbisabesok.com.bukanitip.activity.detailrequest;

import android.view.View;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.addnewoffering.AddNewOfferingActivity;
import dietbisabesok.com.bukanitip.activity.addnewoffering.service.AddOfferingService;
import dietbisabesok.com.bukanitip.activity.addnewrequest.AddNewRequestActivity;
import dietbisabesok.com.bukanitip.activity.listoffering.ListOfferingActivity;
import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.helper.CurrencyHelper;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreen;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreenSwitcher;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class DetailRequestPresenter extends ViewPresenter<DetailRequestView> {
    @Inject
    AddOfferingService mAddOfferingService;

    @Inject
    ActivityScreenSwitcher mActivityScreenSwitcher;

    private DetailRequestActivity mActivity;
    private RequestData mRequestData;
    private String status = null;
    public DetailRequestPresenter(DetailRequestActivity activity, RequestData requestData){
        mActivity = activity;
        mRequestData = requestData;
    }

    @Override
    public void onLoad(){
        super.onLoad();
        Glide.with(mActivity.getApplicationContext())
                .load(mRequestData.img_url)
                .placeholder(R.drawable.borobudur)
                .into(getView().mRequestImageView);
        getView().mRequestName.setText(mRequestData.title);
        getView().mRequestBudget.setText(CurrencyHelper.CurrencyHelper(Long.valueOf(mRequestData.budget)));
        getView().mRequestDescription.setText(mRequestData.description);
        if(mRequestData.status == 1){
            status = "Available for offering";
        }else if(mRequestData.status == 2){
            status = "Pending";
        }else{
            status = "Confirmed";
        }
        getView().mRequestStatus.setText(status);
        onFinishActivity();
        getView().mBtnAddOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivityScreenSwitcher.open(new AddNewOfferingActivity.Screen(mRequestData));
            }
        });

        getView().mBtnListOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivityScreenSwitcher.open(new ListOfferingActivity.Screen());
            }
        });
    }

    private void onFinishActivity(){
        getView().mRequestBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }
}
