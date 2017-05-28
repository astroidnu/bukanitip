package dietbisabesok.com.bukanitip.activity.detailrequest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import dietbisabesok.com.bukanitip.R;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@EViewGroup(R.layout.activity_detail_request)
public class DetailRequestView extends CoordinatorLayout {
    @ViewById(R.id.detail_request_imageview)
    ImageView mRequestImageView;
    @ViewById(R.id.detail_request_back_arrow)
    ImageButton mRequestBackArrow;
    @ViewById(R.id.detail_request_name)
    TextView mRequestName;
    @ViewById(R.id.detail_request_description)
    TextView mRequestDescription;
    @ViewById(R.id.detail_request_budget)
    TextView mRequestBudget;
    @ViewById(R.id.detail_request_status)
    TextView mRequestStatus;
    @ViewById(R.id.detail_request_btn_list_offer)
    Button mBtnListOffer;
    @ViewById(R.id.detail_request_btn_add_offer)
    Button mBtnAddOffer;
    public DetailRequestView(Context context) {
        super(context);
    }
}
