package dietbisabesok.com.bukanitip.activity.showallrequest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.showallrequest.adapter.ShowAllRequestAdapter;
import dietbisabesok.com.bukanitip.data.RequestData;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@EViewGroup(R.layout.activity_show_all_request)
public class ShowAllRequestView extends CoordinatorLayout {
    @ViewById(R.id.toolbar_arrow_left)
    ImageButton mArrowLeft;
    @ViewById(R.id.all_request_recyclerview)
    RecyclerView mRecyclerView;
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;

    private ShowAllRequestAdapter mShowAllRequestAdapter;

    public ShowAllRequestView(Context context) {
        super(context);
    }

    @AfterViews
    void init(){
        mToolbarTitle.setText("All Requests");
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, LinearLayoutManager.VERTICAL, false));;
        mShowAllRequestAdapter = new ShowAllRequestAdapter(getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mShowAllRequestAdapter);
    }

    public void setData(List<RequestData> requestDatas) {
        if (requestDatas != null) {
            mShowAllRequestAdapter.setData(requestDatas);
        }
    }
}
