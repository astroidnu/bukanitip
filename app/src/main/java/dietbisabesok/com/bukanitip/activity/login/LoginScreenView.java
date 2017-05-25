package dietbisabesok.com.bukanitip.activity.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.helper.UIHelper;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */
@EViewGroup(R.layout.activity_login_screen)
public class LoginScreenView extends CoordinatorLayout {
    @ViewById(R.id.login_email)
    EditText mEmail;
    @ViewById(R.id.login_password)
    EditText mPassword;
    @ViewById(R.id.login_btn_submit)
    Button mBtnLogin;
    @ViewById(R.id.login_layout_email)
    TextInputLayout mLayoutEmail;
    @ViewById(R.id.login_layout_password)
    TextInputLayout mLayoutPassword;

    public ProgressDialog mProgressDialog;

    @AfterViews
    void init(){
        mProgressDialog = UIHelper.showProgressDialog(getContext());
    }

    public LoginScreenView(Context context) {
        super(context);
    }

    public void setBtnLoginClickListener(OnClickListener onClickListener){
        mBtnLogin.setOnClickListener(onClickListener);
    }
}
