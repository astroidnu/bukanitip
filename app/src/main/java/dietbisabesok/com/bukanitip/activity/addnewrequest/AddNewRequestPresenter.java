package dietbisabesok.com.bukanitip.activity.addnewrequest;

import android.view.View;

import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class AddNewRequestPresenter extends ViewPresenter<AddNewRequestView> {
    private AddNewRequestActivity mActivity;
    public AddNewRequestPresenter(AddNewRequestActivity addNewRequestActivity) {
        mActivity  = addNewRequestActivity;
    }

    @Override
    public void onLoad(){
        super.onLoad();
        onFinishActivity();
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
