package dietbisabesok.com.bukanitip.fragment.profile;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import de.hdodenhof.circleimageview.CircleImageView;
import dietbisabesok.com.bukanitip.R;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */
@EViewGroup(R.layout.fragment_profile)
public class ProfileFragmentView extends CoordinatorLayout {
    @ViewById(R.id.profile_city)
    TextView mProfileCity;
    @ViewById(R.id.profile_fullname)
    TextView mProfileFullName;
    @ViewById(R.id.profile_header)
    ImageView mProfileHeader;
    @ViewById(R.id.profile_logout)
    Button mProfileLogout;
    @ViewById(R.id.profile_province)
    TextView mProfileProvince;
    @ViewById(R.id.profile_username)
    TextView mProfileUserName;
    @ViewById(R.id.profile_image)
    CircleImageView mProfileImage;
    @AfterViews
    void init(){

    }
    public ProfileFragmentView(Context context) {
        super(context);
    }
}
