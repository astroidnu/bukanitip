package dietbisabesok.com.bukanitip.helper;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class UIHelper {

    public static Toast showToastMessage(Context context, String msg){
        return Toast.makeText(context, msg, Toast.LENGTH_LONG);
    }

    public static ProgressDialog showProgressDialog(Context context){
        ProgressDialog mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setTitle("");
        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);
        return mProgressDialog;
    }

    public static AlertDialog.Builder showAlertDialog(Context context, String title, String msg){
        AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(context);
        mAlertDialog.setTitle(title);
        mAlertDialog.setMessage(msg);
        mAlertDialog.setPositiveButton("OK", (dialog, which) -> {
            //Automatically hide dialog;
        });
        return mAlertDialog;
    }
}
