package dietbisabesok.com.bukanitip.activity.listoffering;

import android.view.View;

import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ListOfferingPresenter extends ViewPresenter<ListOfferingView> {
    private ListOfferingActivity mActivity;
    public ListOfferingPresenter(ListOfferingActivity activity){
        mActivity = activity;
    }
    @Override
    public void onLoad(){
        super.onLoad();
        onFinishActivity();
    }

    private void onFinishActivity() {
        getView().mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }

}
