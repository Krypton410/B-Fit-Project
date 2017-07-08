package com.b_fit.application.b_fit;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Maxwell on 7/8/2017.
 */

public class Connect extends AppCompatActivity {
    CustomSwipeAdapter adapter;
    ViewPager viewPager;
    TextView twitter, ig, fb;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
/*
        viewPager = (ViewPager) findViewById(R.id.ViewPager1);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
*/
        twitter = (TextView) findViewById(R.id.twitter);
        fb = (TextView) findViewById(R.id.facebook);
        ig = (TextView) findViewById(R.id.ig);

        twitter.setText("@EscabarteEdison");
        fb.setText("@EdisonEscabarte");
        ig.setText("@edisonescabarte");


    }
}
