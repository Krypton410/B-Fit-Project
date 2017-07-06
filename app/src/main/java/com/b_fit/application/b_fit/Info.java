package com.b_fit.application.b_fit;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.math.BigDecimal;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.defaultValue;
import static android.R.attr.weightSum;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class Info extends Fragment{
    TextView  gender, age, height;
    static TextView fuckingName, user_Weight;
    Button logout;
    double lbs;
    int lbsToInt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_info, container, false);


        return rootView;
    }



//    @Override
    public void onActivityCreated( Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        logout = (Button) getView().findViewById(R.id.button3);
        fuckingName = (TextView) getView().findViewById(R.id.name);
        gender = (TextView) getView().findViewById(R.id.gender);
        age = (TextView) getView().findViewById(R.id.age);
        height = (TextView) getView().findViewById(R.id.height);
        user_Weight = (TextView) getView().findViewById(R.id.weight);
        double kg = (double) 2.2;



        fuckingName.setText(String.valueOf(DataHolder.getName()));
        gender.setText(DataHolder.getGender());
        age.setText(String.valueOf(DataHolder.getAge()));
        height.setText(String.valueOf(DataHolder.getFeet())+"'"+String.valueOf(DataHolder.getInch()) + " / " + String.valueOf((DataHolder.getFeet()*30.48) + (DataHolder.getInch()*2.54)) + "cm");
        user_Weight.setText(String.valueOf(/*Math.round*/round(Double.valueOf(DataHolder.getWeight()) * 2.205, 3)) + " lbs " + " / " +
        String.valueOf(round(Double.valueOf(DataHolder.getWeight()), 3)) + " Kg");

        //the Default for weight is Kilogram



    logout.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
        Intent i = new Intent(getContext(), Login.class);
            startActivity(i);
            DataHolder.setTraining("0");
        }


    });



    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }





    }





//    public static void postData(EditText getWeigth){
//        user_Weight.setText(getWeigth.getText().toString());
//    }


