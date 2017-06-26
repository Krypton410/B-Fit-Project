package com.b_fit.application.b_fit;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.R.attr.defaultValue;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class Info extends Fragment{
    TextView  gender, age, height, weight;
    TextView Name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info, container, false);


        return rootView;
    }



    @Override
    public void onActivityCreated( Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        Name = (TextView) getView().findViewById(R.id.name);
        gender = (TextView) getView().findViewById(R.id.gender);
        age = (TextView) getView().findViewById(R.id.age);
        height = (TextView) getView().findViewById(R.id.height);
        weight = (TextView) getView().findViewById(R.id.weight);


        }



//    public  void postData(String getName) {
//        name.setText(getName);
//    }
}
