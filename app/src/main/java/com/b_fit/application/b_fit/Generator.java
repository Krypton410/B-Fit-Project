package com.b_fit.application.b_fit;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.view.View.GONE;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class Generator extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_generator, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        RadioGroup theCategory, theStyle;
        Button gen;
        final ProgressBar pb;
        RadioButton beginner,intermediate,advanced, weight, bodyweight, incorporate;
        theCategory = (RadioGroup) getView().findViewById(R.id.category);
        theStyle = (RadioGroup) getView().findViewById(R.id.style);
        beginner = (RadioButton) getView().findViewById(R.id.beginner);
        intermediate = (RadioButton) getView().findViewById(R.id.intermediate);
        advanced = (RadioButton) getView().findViewById(R.id.advanced);
        weight = (RadioButton) getView().findViewById(R.id.weight);
        bodyweight = (RadioButton) getView().findViewById(R.id.bodyweight);
        incorporate = (RadioButton) getView().findViewById(R.id.incorporate);
        pb = (ProgressBar) getView().findViewById(R.id.progressBar);
        gen = (Button) getView().findViewById(R.id.button);
        beginner.setChecked(true);
        bodyweight.setChecked(true);
        pb.setVisibility(GONE);
        gen.setOnClickListener(new View.OnClickListener() {
            int load = 3000;
            @Override
            public void onClick(View v){
                pb.setVisibility(View.VISIBLE);
                pb.setProgress((int) Math.random()*load);

            }
        });





    }
}
