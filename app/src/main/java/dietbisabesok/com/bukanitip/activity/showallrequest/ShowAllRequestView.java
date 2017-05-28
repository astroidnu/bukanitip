package dietbisabesok.com.bukanitip.activity.showallrequest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import dietbisabesok.com.bukanitip.R;

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

    public ShowAllRequestView(Context context) {
        super(context);
    }

    @AfterViews
    void init(){
        mToolbarTitle.setText("All Requests");
    }
}
