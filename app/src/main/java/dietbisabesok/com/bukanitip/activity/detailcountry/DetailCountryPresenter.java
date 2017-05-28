package dietbisabesok.com.bukanitip.activity.detailcountry;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import dietbisabesok.com.bukanitip.activity.detailcountry.adapter.Pager;
import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.fragment.mytrip.MyTripFragment;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class DetailCountryPresenter extends ViewPresenter<DetailCountryView> implements TabLayout.OnTabSelectedListener {
    private DetailCountryActivity mActivity;
    private CountryData mCountryData;
    public DetailCountryPresenter(DetailCountryActivity activity, CountryData countryData) {
        mActivity = activity;
        mCountryData = countryData;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        onFinishActivity();
        getView().mToolbarTitle.setText(mCountryData.getName());
        getView().mTabLayout.addTab(getView().mTabLayout.newTab().setText("Requets"));
        getView().mTabLayout.addTab(getView().mTabLayout.newTab().setText("Diaspora"));
        getView().mTabLayout.setTabGravity(getView().mTabLayout.GRAVITY_FILL);
        //Creating our pager adapter
        Pager adapter = new Pager(mActivity.getSupportFragmentManager(), getView().mTabLayout.getTabCount());
        getView().mDetailContainer.setAdapter(adapter);

        getView().mTabLayout.addOnTabSelectedListener(this);
        getView().mDetailContainer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(getView().mTabLayout));
    }

    private void onFinishActivity() {
        getView().mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        getView().mDetailContainer.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
