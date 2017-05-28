package dietbisabesok.com.bukanitip.activity.addnewoffering;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.helper.UIHelper;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@EViewGroup(R.layout.activity_add_new_offering)
public class AddNewOfferingView extends CoordinatorLayout {
    @ViewById(R.id.new_offering_price)
    EditText mOfferingPrice;
    @ViewById(R.id.new_offering_day_estimation)
    EditText mOfferingDayEstimation;
    @ViewById(R.id.new_offering_description)
    EditText mOfferingDescription;
    @ViewById(R.id.new_offering_submit)
    Button mOfferingSubmit;
    @ViewById(R.id.toolbar_arrow_left)
    ImageButton mArrowLeft;
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;

    public ProgressDialog mProgressDialog;

    @AfterViews
    void init(){
        mProgressDialog = UIHelper.showProgressDialog(getContext());
        mToolbarTitle.setText("Add New Offering");
    }
    public AddNewOfferingView(Context context) {
        super(context);
    }

    public Toast setToastMsg(String msg){
        return UIHelper.showToastMessage(getContext(), msg);
    }
}
