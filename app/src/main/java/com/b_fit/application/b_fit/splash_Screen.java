package com.b_fit.application.b_fit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class splash_Screen extends AppCompatActivity{

    public int getRandomNumber(int min, int max) {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
        setContentView(R.layout.splash_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(splash_Screen.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }

        },getRandomNumber(200,900));}}


