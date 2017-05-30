package dietbisabesok.com.bukanitip.fragment.profile;

import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.login.LoginScreenActivity;
import dietbisabesok.com.bukanitip.data.User;
import dietbisabesok.com.bukanitip.fragment.profile.service.FetchDetailUserResponse;
import dietbisabesok.com.bukanitip.fragment.profile.service.FetchDetailUserService;
import dietbisabesok.com.bukanitip.model.CountryDataModel;
import dietbisabesok.com.bukanitip.model.RequestDataModel;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.session.LoginSession;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreenSwitcher;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class ProfileFragmentPresenter extends ViewPresenter<ProfileFragmentView> {
    @Inject
    FetchDetailUserService mFetchDetailUserService;

    @Inject
    Gson gson;

    @Inject
    LoginSession mLoginSession;

    @Inject
    CountryDataModel mCountryDataModel;

    @Inject
    RequestDataModel mRequestDataModel;

    @Inject
    ActivityScreenSwitcher mACActivityScreenSwitcher;

    private ProfileFragment mFragment;

    public ProfileFragmentPresenter(ProfileFragment profileFragment) {
        mFragment = profileFragment;

    }

    @Override
    public void onLoad(){
        super.onLoad();
        getView().mProfileLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginSession.clear();
                mCountryDataModel.clear();
                mRequestDataModel.clear();
                mACActivityScreenSwitcher.open(new LoginScreenActivity.Screen());

            }
        });
        mFetchDetailUserService.init(mLoginSession.getUserID());
        mFetchDetailUserService.fetchUserInfo(new FetchDetailUserService.GetResponseCallback() {
            @Override
            public void onSuccess(FetchDetailUserResponse dataList) {
                Log.d(getClass().getName(), gson.toJson(dataList.user));
                User user = dataList.user;
                getView().mProfileUserName.setText(user.getUsername());
                getView().mProfileCity.setText(user.getAddress().getCity());
                getView().mProfileProvince.setText(user.getAddress().getProvince());
                getView().mProfileFullName.setText(user.getName());
                Glide.with(mFragment.getContext())
                        .load(user.getLapakHeader())
                        .placeholder(R.drawable.borobudur)
                        .into(getView().mProfileHeader);
                Glide.with(mFragment.getContext())
                        .load(user.getAvatar())
                        .placeholder(R.drawable.borobudur)
                        .into(getView().mProfileImage);
            }

            @Override
            public void onError(NetworkError networkError) {
                Log.e(getClass().getName(),networkError.getMessage());
            }
        });
    }
}
