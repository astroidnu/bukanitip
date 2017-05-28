package dietbisabesok.com.bukanitip.activity.addnewrequest;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.helper.UIHelper;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */
@EViewGroup(R.layout.activity_add_new_request)
public class AddNewRequestView extends CoordinatorLayout {
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;
    @ViewById(R.id.toolbar_arrow_left)
    ImageButton mArrowLeft;
    @ViewById(R.id.new_request_bugdet)
    EditText mBudgetReq;
    @ViewById(R.id.new_request_choose_picture)
    ImageButton mChoosePictureReq;
    @ViewById(R.id.new_request_country)
    EditText mCountryReq;
    @ViewById(R.id.new_request_description)
    EditText mDescriptionReq;
    @ViewById(R.id.new_request_title)
    EditText mTitleReq;
    @ViewById(R.id.new_request_shipping_address)
    EditText mShippingAddress;
    @ViewById(R.id.new_request_submit)
    Button mSubmitReq;
    @ViewById(R.id.new_request_spinner)
    Spinner mCountrySpinner;

    public ProgressDialog mProgressDialog;
    public AddNewRequestView(Context context) {
        super(context);
    }

    @AfterViews
    void init(){
        mProgressDialog = UIHelper.showProgressDialog(getContext());
        mToolbarTitle.setText("Add New Request");
    }

    public Toast setToastMsg(String msg){
        return UIHelper.showToastMessage(getContext(), msg);
    }
}
