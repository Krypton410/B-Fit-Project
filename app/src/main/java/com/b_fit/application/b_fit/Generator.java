package com.b_fit.application.b_fit;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class Generator extends Fragment{
    RadioGroup theCategory, theStyle;
    Button gen;
    TextView statusSetter;
    ProgressBar pb;
    RadioButton beginner,intermediate,advanced, weight, bodyweight, incorporate;
    TextView chest1, chest2, chest3, chest4, back1,back2,back3, back4, abs1, abs2, abs3, abs4, legs1, legs2, legs3, legs4;
    int a,a1,a2,a3,d,d1,d2,d3;
    String[]bchest, ichest;
    int pbTime = (int) (Math.random() * 1000);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_generator, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

                theCategory = (RadioGroup) getView().findViewById(R.id.category);
        statusSetter = (TextView) getView().findViewById(R.id.statusSetter);
        theStyle = (RadioGroup) getView().findViewById(R.id.style);
        beginner = (RadioButton) getView().findViewById(R.id.beginner);
        intermediate = (RadioButton) getView().findViewById(R.id.intermediate);
        advanced = (RadioButton) getView().findViewById(R.id.advanced);
        weight = (RadioButton) getView().findViewById(R.id.weight);
        bodyweight = (RadioButton) getView().findViewById(R.id.bodyweight);
        incorporate = (RadioButton) getView().findViewById(R.id.incorporate);
        pb = (ProgressBar) getView().findViewById(R.id.progressBar);
        int selectedCategory = theCategory.getCheckedRadioButtonId();

        //Initializing All TextViews
        chest1 = (TextView) getView().findViewById(R.id.chest1);
        chest2 = (TextView) getView().findViewById(R.id.chest2);
        chest3 = (TextView) getView().findViewById(R.id.chest3);
        chest4 = (TextView) getView().findViewById(R.id.chest4);


        back1 = (TextView) getView().findViewById(R.id.back1);
        back2 = (TextView) getView().findViewById(R.id.back2);
        back3 = (TextView) getView().findViewById(R.id.back3);
        back4 = (TextView) getView().findViewById(R.id.back4);


        abs1 = (TextView) getView().findViewById(R.id.abs1);
        abs2 = (TextView) getView().findViewById(R.id.abs2);
        abs3 = (TextView) getView().findViewById(R.id.abs3);
        abs4 = (TextView) getView().findViewById(R.id.abs4);


        legs1 = (TextView) getView().findViewById(R.id.legs1);
        legs2 = (TextView) getView().findViewById(R.id.legs2);
        legs3 = (TextView) getView().findViewById(R.id.legs3);
        legs4 = (TextView) getView().findViewById(R.id.legs4);


        //Beginner
        bchest = new String[10];
        bchest[0] = "Declined Push ups";
        bchest[1] = "Inclined Push ups";
        bchest[2] = "Wide Push Ups";
        bchest[3] = "Knuckle Push ups";
        bchest[4] = "Regular Push Ups";
        bchest[5] = "Diamond Push Ups";
        bchest[6] = "Explosive Regular Push ups";
        bchest[7] = "Wall push ups";
        bchest[8] = "Spiderman Push ups";
        bchest[9] = "Plank to push ups";
        a = (int) (Math.random()*10);
        a1 = (int) (Math.random()*10);
        a2 = (int) (Math.random()*10);
        a3 = (int) (Math.random()*10);




        //Intermediate
        ichest = new String[10];
        ichest[0] = "Clapping Push Ups";
        ichest[1] = "Finger tip Push ups";
        ichest[2] = "Uneven Push ups (Side to side)";
        ichest[3] = "Regular PU to Diamond PU";
        ichest[4] = "Wide Push ups to Normal Push Ups";
        ichest[5] = "Shoulder tap Push ups";
        ichest[6] = "Regular PU to X PU";
        ichest[7] = "Chest Tap Push ups";
        ichest[8] = "Russian Push ups";
        ichest[9] = "Weighted Push ups";
        d = (int) (Math.random()*10);
        d1 = (int) (Math.random()*10);
        d2 = (int) (Math.random()*10);
        d3 = (int) (Math.random()*10);


        //Setting Visibility False/Gone
        chest1.setVisibility(GONE);
        chest2.setVisibility(GONE);
        chest3.setVisibility(GONE);
        chest4.setVisibility(GONE);

        back1.setVisibility(GONE);
        back2.setVisibility(GONE);
        back3.setVisibility(GONE);
        back4.setVisibility(GONE);

        abs1.setVisibility(GONE);
        abs2.setVisibility(GONE);
        abs3.setVisibility(GONE);
        abs4.setVisibility(GONE);

        legs1.setVisibility(GONE);
        legs2.setVisibility(GONE);
        legs3.setVisibility(GONE);
        legs4.setVisibility(GONE);


        gen = (Button) getView().findViewById(R.id.button);
        beginner.setChecked(true);
        bodyweight.setChecked(true);
        pb.setVisibility(GONE);
        statusSetter.setVisibility(GONE);
        gen.setOnClickListener(new View.OnClickListener() {
            int load = 3000;

            @Override
            public void onClick(View v) {

                int selectedCategory = theCategory.getCheckedRadioButtonId();
                String category_Picked = ((RadioButton)getView().findViewById(selectedCategory)).getText().toString();
                pb.setVisibility((VISIBLE));
                statusSetter.setText(category_Picked + "'s Workout");
                if (selectedCategory == R.id.beginner){
                    statusSetter.setVisibility(GONE);
                chest1.setText(bchest[a]);
                chest2.setText(bchest[a1]);
                chest3.setText(bchest[a2]);
                chest4.setText(bchest[a3]);


                chest1.setVisibility(View.VISIBLE);
                chest2.setVisibility(View.VISIBLE);
                chest3.setVisibility(View.VISIBLE);
                chest4.setVisibility(View.VISIBLE);
            }

            else if(selectedCategory == R.id.intermediate){

                    statusSetter.setVisibility(GONE);

                    chest1.setText(ichest[d]);
                    chest2.setText(ichest[d1]);
                    chest3.setText(ichest[d2]);
                    chest4.setText(ichest[d3]);

                    chest1.setVisibility(View.VISIBLE);
                    chest2.setVisibility(View.VISIBLE);
                    chest3.setVisibility(View.VISIBLE);
                    chest4.setVisibility(View.VISIBLE);


                }

        }

        });




    }



}
