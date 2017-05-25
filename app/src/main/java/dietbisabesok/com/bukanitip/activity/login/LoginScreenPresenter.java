package dietbisabesok.com.bukanitip.activity.login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.activity.home.HomeScreenActivity;
import dietbisabesok.com.bukanitip.activity.login.service.LoginResponse;
import dietbisabesok.com.bukanitip.activity.login.service.LoginService;
import dietbisabesok.com.bukanitip.helper.UIHelper;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.session.LoginSession;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import dietbisabesok.com.bukanitip.ui.navigation.ActivityScreenSwitcher;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */
public class LoginScreenPresenter extends ViewPresenter<LoginScreenView> {
    @Inject
    Gson gson;

    @Inject
    LoginService mLoginService;

    @Inject
    LoginSession mLoginSession;

    @Inject
    ActivityScreenSwitcher mActivityScreenSwitcher;

    private LoginScreenActivity mActivity;
    private String mUsername = null;
    private String mPassword = null;

    public LoginScreenPresenter(LoginScreenActivity loginScreenActivity) {
        mActivity = loginScreenActivity;
    }

    @Override
    public void onLoad(){
        super.onLoad();
        btnLoginOnClick();
    }

    private void btnLoginOnClick(){
        getView().setBtnLoginClickListener(v -> {
            login();
        });
    }

    private void login(){
        mUsername = getView().mEmail.getText().toString();
        mPassword  = getView().mPassword.getText().toString();
        inputValidation();
        //Call API
        if(isValidEmail(mUsername) && isValidPassword(mPassword)){
            getView().mProgressDialog.show();
            mLoginService.init(getView().mEmail.getText().toString(), getView().mPassword.getText().toString());
            mLoginService.userLogin(new LoginService.GetResponseCallback() {
                @Override
                public void onSuccess(LoginResponse dataList) {
                    getView().mProgressDialog.dismiss();
                    Log.d(getClass().getName(), gson.toJson(dataList));
                    mLoginSession.saveToken(dataList.token);
                    mLoginSession.saveUsername(dataList.user_name);
                    mLoginSession.saveUserID(dataList.user_id);
                    mLoginSession.saveEmail(dataList.email);
                    mActivityScreenSwitcher.open(new HomeScreenActivity.Screen());
                }

                @Override
                public void onError(NetworkError networkError) {
                    getView().mProgressDialog.dismiss();
                    getView().setToastMsg(networkError.getMessage());
                    Log.e(getClass().getName(), networkError.getMessage());
                }
            });
        }else{
            Log.e(getClass().getName(), "Failed login input validation");
        }
    }

    private void inputValidation(){
        isValidEmail(mUsername);
        isValidPassword(mPassword);

        getView().mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isValidEmail(s);
            }
        });

        getView().mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isValidPassword(s);
            }
        });
    }

    public boolean isValidEmail(CharSequence target) {
        if (target == null) {
            getView().mLayoutEmail.setError("Please input email or username");
            return false;
        } else {
            if(target.length() > 6){
                getView().mLayoutEmail.setError("");
                if(target.toString().contains("@")){
                    return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
                }else{
                    return true;
                }
            }else{
                if(target.toString().contains("@")){
                    getView().mLayoutEmail.setError("Minimum email character 6");
                }else{
                    getView().mLayoutEmail.setError("Minimum username character 6");
                }
                return  false;
            }

        }
    }

    public boolean isValidPassword(CharSequence target){
        if(target == null){
            getView().mLayoutPassword.setError("Please input password");
            return false;
        }else {
            if(target.length() > 6){
                getView().mLayoutPassword.setError("");
                return true;
            }else{
                getView().mLayoutPassword.setError("Minimum password character 6");
                return false;
            }
        }

    }

}
