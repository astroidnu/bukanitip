package dietbisabesok.com.bukanitip.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import org.androidannotations.annotations.EActivity;

import java.util.Locale;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.home.HomeScreenActivity;
import dietbisabesok.com.bukanitip.activity.login.LoginScreenActivity;
import dietbisabesok.com.bukanitip.session.LoginSession;

@EActivity(R.layout.activity_splash_screen)
public class SplashScreen extends AppCompatActivity {
    //a countdown timer to show the splash screen
    private CountDownTimer timer = new CountDownTimer(2000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            redirect();
        }
    };

    private void redirect() {
        LoginSession session = new LoginSession();
        if (!session.isInitialized()) {
            redirectToLogin();
        } else {
            redirectToHome();
        }
    }

    private void redirectToLogin() {
        Intent intent = new Intent(this, LoginScreenActivity.class);
        startActivity(intent);
        finish();
    }

    private void redirectToHome() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (isTaskRoot()) {
            timer.start();
        } else {
            redirect();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }
}