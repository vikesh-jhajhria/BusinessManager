package com.businessmanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.businessmanager.utils.Config;

import java.util.Date;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startTimer();
    }

    private void startTimer() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(preferences.getLoginStatus()) {
                    /*long loginTime = preferences.getLoginTime();
                    Log.v(TAG, "logintime=" + loginTime);
                    if (loginTime < new Date().getTime() - (1000 * 60 * 10)) {
                        startActivity(new Intent(getApplicationContext(), PinActivity.class));
                        finishAffinity();
                    } else {*/
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finishAffinity();
                    //}
                } else{
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finishAffinity();
                }
            }
        }, Config.SPLASH_TIME);
    }
}
