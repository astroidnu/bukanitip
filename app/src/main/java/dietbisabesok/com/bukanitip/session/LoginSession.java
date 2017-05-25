package dietbisabesok.com.bukanitip.session;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import dietbisabesok.com.bukanitip.app.BukaNitipApp;

/**
 * Created by Ibnu Muzzakkir on 11/12/2016.
 * Contact ibnumuzzaakkir@gmail.com
 * scoproject
 */

public class LoginSession {

    /**
     * indicate if the user login session ever exists
     */
    public boolean isLogin;

    private Pref pref;

    public LoginSession() {
        this.isLogin = false;
        pref = new Pref();
        isLogin = !TextUtils.isEmpty(getLoginToken());
    }

    private final String PREF_TOKEN = "token";
    private final String PREF_USERNAME = "username";
    private final String PREF_USERID = "userid";
    private final String PREF_USEREMAIL = "email";

    private class Pref extends BaseSharedPreferences {

        private Pref() {
            check();
        }

        @Override
        protected Context __getApplicationContext() {
            return BukaNitipApp.getApp();
        }

        @Override
        protected String _getUserProfileName() {
            return "user_session";
        }
    }
    public String getUserID() {
        return pref._getString(PREF_USERID, "");
    }

    public void saveUserID(long userid) {
        pref._setString(PREF_USERID, String.valueOf(userid));
    }
    public String getEmail() {
        return pref._getString(PREF_USEREMAIL, "");
    }

    public void saveEmail(String email) {
        pref._setString(PREF_USEREMAIL, email);
    }

    public String getLoginToken() {
        Log.d(getClass().getName(), "Token : "+pref._getString(PREF_TOKEN, ""));
        return pref._getString(PREF_TOKEN, "");
    }

    public void saveToken(String token) {
        pref._setString(PREF_TOKEN, token);
        isLogin = true;
    }

    public void saveUsername(String username){
        pref._setString(PREF_USERNAME, username);
    }

    public String getUsername(){ return  pref._getString(PREF_USERNAME, "");}

    /**
     * check if everything has been initialized
     *
     * @return true if the passcode has been initialized
     */
    public boolean isInitialized() {
        return !TextUtils.isEmpty(getLoginToken());
    }

    private Exception mLoginError;

    public void setLoginError(Exception e){
        mLoginError = e;
    }

    public Exception getLoginError(){
        return mLoginError;
    }

    public void clear() {
        //clear the login session
        pref._clear();
        isLogin = false;
    }
}
