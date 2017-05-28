package dietbisabesok.com.bukanitip.fragment.myrequest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.data.MyRequestData;
import dietbisabesok.com.bukanitip.fragment.myrequest.adapter.MyRequestAdapter;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */
@EViewGroup(R.layout.fragment_my_request)
public class MyRequestFragmentView extends CoordinatorLayout {
    @ViewById(R.id.my_request_recyclerview)
    RecyclerView mRequestRecyclerView;

    private MyRequestAdapter myRequestAdapter;

    public MyRequestFragmentView(Context context) {
        super(context);
    }


    @AfterViews
    void init(){
        myRequestAdapter = new MyRequestAdapter(getContext());
        mRequestRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, LinearLayoutManager.VERTICAL, false));
        mRequestRecyclerView.setAdapter(myRequestAdapter);
    }

    void setData(List<MyRequestData> dataList){
        if(dataList != null){
            myRequestAdapter.setData(dataList);
        }
    }
}
