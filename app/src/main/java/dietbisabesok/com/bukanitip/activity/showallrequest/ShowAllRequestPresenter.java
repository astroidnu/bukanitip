package dietbisabesok.com.bukanitip.activity.showallrequest;

import android.view.View;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.model.RequestDataModel;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ShowAllRequestPresenter extends ViewPresenter<ShowAllRequestView> {
    @Inject
    RequestDataModel mRequestDataModel;

    private ShowAllRequestActivity mActivity;
    public ShowAllRequestPresenter(ShowAllRequestActivity showAllRequestActivity) {
        mActivity = showAllRequestActivity;
    }
    @Override
    public void onLoad(){
        super.onLoad();
        onFinishActivity();
        getView().setData(mRequestDataModel.loadAll());
    }

    private void onFinishActivity(){
        getView().mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }
}
