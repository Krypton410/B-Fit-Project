package com.b_fit.application.b_fit;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_info, container, false);


        return rootView;
    }





//    @Override
    public void onActivityCreated( Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        fuckingName = (TextView) getView().findViewById(R.id.name);
        gender = (TextView) getView().findViewById(R.id.gender);
        age = (TextView) getView().findViewById(R.id.age);
        height = (TextView) getView().findViewById(R.id.height);
        user_Weight = (TextView) getView().findViewById(R.id.weight);

        fuckingName.setText(String.valueOf(DataHolder.getName()));
        gender.setText(DataHolder.getGender());
        age.setText(String.valueOf(DataHolder.getAge()));
        height.setText(String.valueOf(DataHolder.getFeet())+"'"+String.valueOf(DataHolder.getInch()));
        user_Weight.setText(String.valueOf(DataHolder.getWeight()) + " Kg");
        }

//    public static void postData(EditText getWeigth){
//        user_Weight.setText(getWeigth.getText().toString());
//    }

}
