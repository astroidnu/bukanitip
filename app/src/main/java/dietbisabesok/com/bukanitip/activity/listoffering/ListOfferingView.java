package dietbisabesok.com.bukanitip.activity.listoffering;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import dietbisabesok.com.bukanitip.R;

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

    @AfterViews
    void init(){
        mToolbarTitle.setText("List Offering");
    }
    public ListOfferingView(Context context) {
        super(context);
    }
}
