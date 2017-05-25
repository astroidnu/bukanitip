package dietbisabesok.com.bukanitip.activity.home;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import java.util.HashMap;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.fragment.home.HomeFragment;
import dietbisabesok.com.bukanitip.fragment.profile.ProfileFragment;
import dietbisabesok.com.bukanitip.helper.AppConst;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeScreenPresenter extends ViewPresenter<HomeScreenView> {

    private HomeScreenActivity mActivity;
    private HashMap<String, Fragment> fragments;
    private Fragment currentFragment;
    private HomeFragment mHomeFragment;
    private ProfileFragment mProfileFragment;
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
    }

    private void setupFragment(){
        mHomeFragment = new HomeFragment();
        mProfileFragment = new ProfileFragment();
        fragments = new HashMap<>();
        fragments.put(AppConst.fragment_type.TAG_FRAGMENT_HOME, mHomeFragment);
        fragments.put(AppConst.fragment_type.TAG_FRAGMENT_PROFILE, mProfileFragment);
    }

    private void setupBottomBar(){
        getView().mBottomBar.setOnTabReselectListener(tabId -> {
            if(tabId == R.id.home){
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_HOME, VISIBLE, VISIBLE, VISIBLE);
            }else{
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_PROFILE, GONE, GONE, GONE);
            }
        });
        getView().mBottomBar.setOnTabSelectListener(tabId -> {
            if(tabId == R.id.home){
                loadFragment(AppConst.fragment_type.TAG_FRAGMENT_HOME, VISIBLE, VISIBLE, VISIBLE);
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
            getView().mToolbar.setVisibility(View.VISIBLE);
        }
    }
    public Fragment getCurrentFragment(){
        return currentFragment;
    }
}
