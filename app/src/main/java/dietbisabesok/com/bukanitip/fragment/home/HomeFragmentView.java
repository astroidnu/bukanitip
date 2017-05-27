package dietbisabesok.com.bukanitip.fragment.home;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.data.SectionDataModel;
import dietbisabesok.com.bukanitip.data.SectionSecondDataModel;
import dietbisabesok.com.bukanitip.fragment.home.adapter.ItemSectionAdapter;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */
@EViewGroup(R.layout.fragment_home)
public class HomeFragmentView extends CoordinatorLayout {

    @ViewById(R.id.fragment_home_recyclerview_horizontal)
    RecyclerView mRecyclerViewHorizontal;

    private ItemSectionAdapter mItemSectionAdapter;
    private LayoutInflater mLayoutInflater;

    @AfterViews
    void init(){
        mRecyclerViewHorizontal.setLayoutManager(new GridLayoutManager(getContext(),1,LinearLayoutManager.VERTICAL, false));
        mItemSectionAdapter = new ItemSectionAdapter(getContext());
        mRecyclerViewHorizontal.setHasFixedSize(true);
        mRecyclerViewHorizontal.setAdapter(mItemSectionAdapter);
    }

    public HomeFragmentView(Context context) {
        super(context);
        mLayoutInflater = LayoutInflater.from(getContext());
    }

    public void setAdapterHorizontal(List<SectionDataModel> addressList, List<SectionSecondDataModel> datas, ArrayList<Integer> imageList) {
        if (addressList != null && datas != null) {
            mItemSectionAdapter.setDataList(addressList,datas, imageList);
        }
    }
}
