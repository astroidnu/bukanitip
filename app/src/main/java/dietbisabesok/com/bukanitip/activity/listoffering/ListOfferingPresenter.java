package dietbisabesok.com.bukanitip.activity.listoffering;

import android.view.View;

import java.util.List;

import dietbisabesok.com.bukanitip.data.ListOfferingData;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ListOfferingPresenter extends ViewPresenter<ListOfferingView> {
    private ListOfferingActivity mActivity;
    private List<ListOfferingData> mListOfferingDatas;
    public ListOfferingPresenter(ListOfferingActivity activity, List<ListOfferingData> dataList){
        mActivity = activity;
        mListOfferingDatas = dataList;
    }
    @Override
    public void onLoad(){
        super.onLoad();
        onFinishActivity();
        getView().setData(mListOfferingDatas);
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
