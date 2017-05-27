package dietbisabesok.com.bukanitip.activity.addnewrequest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import dietbisabesok.com.bukanitip.R;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */
@EViewGroup(R.layout.activity_add_new_request)
public class AddNewRequestView extends CoordinatorLayout {
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;
    @ViewById(R.id.toolbar_arrow_left)
    ImageButton mArrowLeft;
    public AddNewRequestView(Context context) {
        super(context);
    }

    @AfterViews
    void init(){
        mToolbarTitle.setText("Add New Request");
    }
}
