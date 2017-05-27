package dietbisabesok.com.bukanitip.activity.home;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import java.util.HashMap;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.addnewrequest.AddNewRequestActivity;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllCountryListService;
import dietbisabesok.com.bukanitip.fragment.home.HomeFragment;
import dietbisabesok.com.bukanitip.fragment.myrequest.MyRequestFragment;
import dietbisabesok.com.bukanitip.fragment.mytrip.MyTripFragment;
import dietbisabesok.com.bukanitip.fragment.profile.ProfileFragment;
import dietbisabesok.com.bukanitip.helper.AppConst;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreenSwitcher;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeScreenPresenter extends ViewPresenter<HomeScreenView> {
    @Inject
    ActivityScreenSwitcher mScreenSwitcher;

    private HomeScreenActivity mActivity;
    private HashMap<String, Fragment> fragments;
    private Fragment currentFragment;
    private HomeFragment mHomeFragment;
    private ProfileFragment mProfileFragment;
    private MyRequestFragment mMyRequestFragment;
    private MyTripFragment mMyTripFragment;
    private final Handler mDrawerHandler = new Handler();

    public HomeScreenPresenter(HomeScreenActivity homeScreenActivity) {
        mActivity = homeScreenActivity;

    }

    @Override
    public void onLoad(){
        super.onLoad();
        getView().mToolbar.setVisibility(View.VISIBLE);
        setupFragment();
        setupBottomBar();

        getView().mMenuMyRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getView().mFloatingActionMenu.close(true);
                mScreenSwitcher.open(new AddNewRequestActivity.Screen());
            }
        });
        getView().mFloatingActionMenu.setClosedOnTouchOutside(true);
    }

    private void setupFragment(){
        mHomeFragment = new HomeFragment();
        mProfileFragment = new ProfileFragment();
        mMyRequestFragment = new MyRequestFragment();
        mMyTripFragment = new MyTripFragment();
        fragments = new HashMap<>();
        fragments.put(AppConst.fragment_type.TAG_FRAGMENT_HOME, mHomeFragment);
        fragments.put(AppConst.fragment_type.TAG_FRAGMENT_PROFILE, mProfileFragment);
        fragments.put(AppConst.fragment_type.TAG_FRAGMENT_MY_TRIP, mMyTripFragment);
        fragments.put(AppConst.fragment_type.TAG_FRAGMENT_MY_REQUEST, mMyRequestFragment);
    }

    private void setupBottomBar(){
        getView().mBottomBar.setOnTabReselectListener(tabId -> {
            if(tabId == R.id.home){
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_HOME, VISIBLE, VISIBLE, VISIBLE);
            }else if(tabId == R.id.request){
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_MY_REQUEST, VISIBLE, VISIBLE, VISIBLE);
            }else if(tabId == R.id.trip){
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_MY_TRIP, VISIBLE, VISIBLE, VISIBLE);
            }else{
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_PROFILE, GONE, GONE, GONE);
            }
        });
        getView().mBottomBar.setOnTabSelectListener(tabId -> {
            if(tabId == R.id.home){
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_HOME, VISIBLE, VISIBLE, VISIBLE);
            }else if(tabId == R.id.request){
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_MY_REQUEST, VISIBLE, VISIBLE, VISIBLE);
            }else if(tabId == R.id.trip) {
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_MY_TRIP, VISIBLE, VISIBLE, VISIBLE);
            }else{
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_PROFILE, GONE, GONE, GONE);
            }
        });
    }

    public void loadFragment(String fragmentId, int statDefaultBar, int statSearchBar, int statAddNewSchedule){
        mDrawerHandler.removeCallbacksAndMessages(null);
        mDrawerHandler.postDelayed(() -> {
            FragmentTransaction transaction = mActivity.getSupportFragmentManager().beginTransaction();
            currentFragment = fragments.get(fragmentId);
            transaction.replace(R.id.home_fragment_container, currentFragment, fragmentId);
            transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left);
            transaction.addToBackStack(null);
            transaction.commit();
        }, 1);
        if (fragmentId != null) {
            if(fragmentId == AppConst.fragment_type.TAG_FRAGMENT_HOME){
                getView().mToolbarTitle.setText(R.string.fragment_home);
                getView().mFloatingActionMenu.setVisibility(View.VISIBLE);
            }else if(fragmentId == AppConst.fragment_type.TAG_FRAGMENT_MY_REQUEST){
                getView().mToolbarTitle.setText(R.string.fragment_my_request);
                getView().mFloatingActionMenu.setVisibility(View.VISIBLE);
            }else if(fragmentId == AppConst.fragment_type.TAG_FRAGMENT_MY_TRIP){
                getView().mToolbarTitle.setText(R.string.fragment_my_trip);
                getView().mFloatingActionMenu.setVisibility(View.VISIBLE);
            }else if(fragmentId == AppConst.fragment_type.TAG_FRAGMENT_PROFILE){
                getView().mToolbarTitle.setText(R.string.fragment_my_profile);
                getView().mFloatingActionMenu.setVisibility(View.GONE);
            }else{
                getView().mFloatingActionMenu.setVisibility(View.GONE);
                getView().mToolbarTitle.setText(R.string.fragment_home);
            }
        }
    }
    public Fragment getCurrentFragment(){
        return currentFragment;
    }
}
