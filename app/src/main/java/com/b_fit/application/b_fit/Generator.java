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
    int a,a1,a2,a3, b, b1, b2, b3, ba, ba1, ba2, ba3, c, c1, c2, c3, d,d1,d2,d3, e, e1, e2, e3, f, f1, f2, f3;
    String[]bchest, bback, babs, blegs, ichest, iback, iabs;
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


        //Chest for Beginner
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




       //Back for Beginner
        bback = new String[9];
        bback[0] = "Australian Pull Ups";
        bback[1] = "1 arm Australian pull ups";
        bback[2] = "Chin ups";
        bback[3] = "Good Mornings";
        bback[4] = "Reverse Archer Sit ups";
        bback[5] = "Reverse Snow Angels";
        bback[6] = "Negative Pull ups";
        bback[7] = "Negative Chin Ups";
        bback[8] = "Australian Chin ups";
        b = (int) (Math.random()*9);
        b1 = (int) (Math.random()*9);
        b2 = (int) (Math.random()*9);
        b3 = (int) (Math.random()*9);

        //abs for beginner
        babs = new String[10];
        babs[0] = "Sit ups";
        babs[1] = "knee planks";
        babs[2] = "V ups";
        babs[3] = "Plank Ups";
        babs[4] = "Reverse plank ups";
        babs[5] = "Lying Leg Raise";
        babs[6] = "Single arm plank";
        babs[7] = "Straddle planks";
        babs[8] = "Straddle V ups";
        babs[9] = "Crunches";
        ba = (int) (Math.random()*10);
        ba1 = (int) (Math.random()*10);
        ba2 = (int) (Math.random()*10);
        ba3 = (int) (Math.random()*10);

       //legs for beginner
        blegs = new String[9];
        blegs[0] = "Regular Squat";
        blegs[1] = "close squat";
        blegs[2] = "Bulgarian Split Squat";
        blegs[3] = "Side Lunges";
        blegs[4] = "Cossack squat";
        blegs[5] = "Sumo squats";
        blegs[6] = "Hindu squats";
        blegs[7] = "Frog Jumps";
        blegs[8] = "Jumping Lunges";
        c = (int) (Math.random()*9);
        c1 = (int) (Math.random()*9);
        c2 = (int) (Math.random()*9);
        c3 = (int) (Math.random()*9);

        //Chest for Intermediate
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



       //Back for intemediate
        iback = new String[9];
        iback[0] = "Pull Ups";
        iback[1] = "Close grip Pull ups";
        iback[2] = "Wide grip Pull ups";
        iback[3] = "Wide grip Chin ups";
        iback[4] = "Close grip chin ups";
        iback[5] = "Slow PU (5 sec up 5 sec down)";
        iback[6] = "Alternate grip switch PU/CU";
        iback[7] = "Weighted Australian PU";
        iback[8] = "Weighted Australian CU";
        e = (int) (Math.random()*9);
        e1 = (int) (Math.random()*9);
        e2 = (int) (Math.random()*9);
        e3 = (int) (Math.random()*9);


       //Abs for intermediate
        iabs = new String[9];
        iabs[0] = "knee raise";
        iabs[1] = "knee oblique twist(bar)";
        iabs[2] = "oblique twists";
        iabs[3] = "Side Plank";
        iabs[4] = "Leg raises(Ground)";
        iabs[5] = "Pike ups";
        iabs[6] = "Crossfit toe to bar";
        iabs[7] = "Hollow body hold half";
        iabs[8] = "Abs slider (Towel)";
        f = (int) (Math.random()*9);
        f1 = (int) (Math.random()*9);
        f2 = (int) (Math.random()*9);
        f3 = (int) (Math.random()*9);



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
