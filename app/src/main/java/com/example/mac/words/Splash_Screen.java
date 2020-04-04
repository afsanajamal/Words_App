package com.example.mac.words;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash__screen);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                waitScreen();
                startmainactivity();
            }
        });
        thread.start();
    }

    public void waitScreen() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startmainactivity() {
        Intent intentLoadNewActivity = new Intent(Splash_Screen.this, MainActivity.class);
        startActivity(intentLoadNewActivity);
        finish();
    }
}
