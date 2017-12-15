package com.businessmanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.businessmanager.utils.AppPreferences;
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
                long loginTime = preferences.getLoginTime();
                Log.v(TAG, "logintime=" + loginTime);
                if (loginTime < new Date().getTime() - 10000) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finishAffinity();
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finishAffinity();
                }
            }
        }, Config.SPLASH_TIME);
    }
}
