package dietbisabesok.com.bukanitip.activity.listoffering;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.listoffering.adapter.ListOfferingAdapter;
import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.data.ListOfferingData;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@EViewGroup(R.layout.activity_list_offering)
public class ListOfferingView extends CoordinatorLayout {
    @ViewById(R.id.list_offering_recyclerview)
    RecyclerView mListOfferingRecyclerView;
    @ViewById(R.id.toolbar_arrow_left)
    ImageButton mArrowLeft;
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;

    private ListOfferingAdapter mListOfferingAdapter;
    @AfterViews
    void init(){
        mToolbarTitle.setText("List Offering");
        mListOfferingAdapter = new ListOfferingAdapter(getContext());
        mListOfferingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mListOfferingRecyclerView.setHasFixedSize(true);
        mListOfferingRecyclerView.setAdapter(mListOfferingAdapter);
    }

    public void setData(List<ListOfferingData> listOfferingDatas) {
        if (listOfferingDatas != null) {
            mListOfferingAdapter.setData(listOfferingDatas);
        }
    }

    public ListOfferingView(Context context) {
        super(context);
    }
}
