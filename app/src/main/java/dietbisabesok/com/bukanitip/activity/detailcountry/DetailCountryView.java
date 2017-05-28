package dietbisabesok.com.bukanitip.activity.detailcountry;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@EViewGroup(R.layout.activity_detail_country)
public class DetailCountryView extends CoordinatorLayout{
    @ViewById(R.id.toolbar_arrow_left)
    ImageButton mArrowLeft;
    @ViewById(R.id.toolbar_title)
    TextView mToolbarTitle;
    @ViewById(R.id.detail_country_container)
    ViewPager mDetailContainer;
    @ViewById(R.id.detail_country_tab_layout)
    TabLayout mTabLayout;
    public DetailCountryView(Context context) {
        super(context);
    }

    @AfterViews
    void init(){

    }



}
