package com.b_fit.application.b_fit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Maxwell on 7/2/2017.
 */

public class Base extends AppCompatActivity {
    SharedPreferences pref2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        pref2 = getSharedPreferences("user_Info", Context.MODE_PRIVATE);


        if(DataHolder.getLogged() == false){
            Intent i = new Intent(Base.this, Login.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            }
        else{

            Intent i = new Intent(Base.this, splash_Screen.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }


    }
}
