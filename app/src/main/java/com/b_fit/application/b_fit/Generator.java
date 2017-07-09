package com.b_fit.application.b_fit;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.transition.Visibility;
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
    String[]bchest, bback, babs, blegs, ichest, iback, iabs, ilegs, achest, aback, abs, alegs;
    int pbTime = (int) (Math.random() * 1000);
    int progress = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_generator, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        final Handler handler = new Handler();
        pb = (ProgressBar) getView().findViewById(R.id.progressBar);


        theCategory = (RadioGroup) getView().findViewById(R.id.category);
        statusSetter = (TextView) getView().findViewById(R.id.statusSetter);
        theStyle = (RadioGroup) getView().findViewById(R.id.style);
        beginner = (RadioButton) getView().findViewById(R.id.beginner);
        intermediate = (RadioButton) getView().findViewById(R.id.intermediate);
        advanced = (RadioButton) getView().findViewById(R.id.advanced);
        weight = (RadioButton) getView().findViewById(R.id.weight);
        bodyweight = (RadioButton) getView().findViewById(R.id.bodyweight);
        incorporate = (RadioButton) getView().findViewById(R.id.incorporate);

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

        DataHolder.setExercise(ichest);

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


        //Legs for intermediate
        ilegs = new String[7];
        ilegs[0] = "Explosive Squats";
        ilegs[1] = "Box Jumps";
        ilegs[2] = "Single leg exlplosive squats";
        ilegs[3] = "Weighted Squats";
        ilegs[4] = "Burpees";
        ilegs[5] = "Weighted Wide squat";
        ilegs[6] = "Assisted pistol squat";

        //Chest for advanced
        achest = new String[10];
        achest[0] = "One Arm Push ups";
        achest[1] = "Typewriter Push ups";
        achest[2] = "Archer Push Ups";
        achest[3] = "Stationary Superman Push Ups";
        achest[4] = "Superman Push Ups";
        achest[5] = "Toe touch push ups aka 'Aztec Push Ups'";
        achest[6] = "Single arm toe touch  push ups";
        achest[7] = "Pseudo push ups";
        achest[8] = "Back Clap Push Ups";
        achest[9] = "OA clapping push ups(each arms)";

        //Back for advanced
        aback = new String[10];
        aback[0] = "Clapping pull ups";
        aback[1] = "Typewriter pull ups";
        aback[2] = "Archer Pull Ups";
        aback[3] = "Assisted One Arm pull ups";
        aback[4] = "OAPU Negatives";
        aback[5] = "Weighted pull ups";
        aback[6] = "CG high Pull ups";
        aback[7] = "WG high pull ups";
        aback[8] = "Muscle Ups";
        aback[9] = "WG muscle ups";


        //Legs for advanced
        alegs = new String[8];
        alegs[0] = "Pistol squat(each leg)";
        alegs[1] = "Weighted Pistol squat";
        alegs[2] = "Alternate PS (Each legs)";
        alegs[3] = "Diamond Squats";
        alegs[4] = "Reverse Lunge Shrimp Squat";
        alegs[5] = "Falling Tower";
        alegs[6] = "Kneel to explosive squat";
        alegs[7] = "Alternate Explosive PS";

        //Abs for advanced
        abs = new String[7];
        abs[0] = "L sit(Bar)";
        abs[1] = "Leg raise(Half)";
        abs[2] = "Leg raise(Full)";
        abs[3] = "L sit(Floor)";
        abs[4] = "Full Hollow Body Hold";
        abs[5] = "Dragon Flags";
        abs[6] = "Ab roller";


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

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progress < getRandomNumber(2,10)){
                            progress++;
                            android.os.SystemClock.sleep(getRandomNumber(2,10));
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pb.setProgress(progress);
                                }
                            });

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                new Handler().postDelayed(new Runnable(){
                                    @Override
                                    public void run(){
                                        pb.setVisibility(View.VISIBLE);
                                    }

                                },getRandomNumber(2,10));
                                pb.setVisibility(View.GONE);
                            }
                        });

                    }}}
                ).start();









                int selectedCategory = theCategory.getCheckedRadioButtonId();
                int selectedStyle = theStyle.getCheckedRadioButtonId();
                String category_Picked = ((RadioButton)getView().findViewById(selectedCategory)).getText().toString();
                pb.setVisibility((GONE));

                if (selectedCategory == R.id.beginner){

                    if(selectedStyle == R.id.bodyweight){

                    statusSetter.setText(category_Picked+" 's Category");
                    statusSetter.setVisibility(VISIBLE);
                    chest1.setText(bchest[getRandomNumber(0,9)]);
                    chest2.setText(bchest[getRandomNumber(0,9)]);
                    chest3.setText(bchest[getRandomNumber(0,9)]);
                    chest4.setText(bchest[getRandomNumber(0,9)]);

                    back1.setText(bback[getRandomNumber(0,8)]);
                    back2.setText(bback[getRandomNumber(0,8)]);
                    back3.setText(bback[getRandomNumber(0,8)]);
                    back4.setText(bback[getRandomNumber(0,8)]);

                    abs1.setText(babs[getRandomNumber(0,9)]);
                    abs2.setText(babs[getRandomNumber(0,9)]);
                    abs3.setText(babs[getRandomNumber(0,9)]);
                    abs4.setText(babs[getRandomNumber(0,9)]);

                    generate(legs1, blegs[getRandomNumber(0,8)]);
                    generate(legs2, blegs[getRandomNumber(0,8)]);
                    generate(legs3, blegs[getRandomNumber(0,8)]);
                    generate(legs4, blegs[getRandomNumber(0,8)]);}

                    else if(selectedStyle == R.id.weight){




                    }

                    chest1.setVisibility(View.VISIBLE);
                    chest2.setVisibility(View.VISIBLE);
                    chest3.setVisibility(View.VISIBLE);
                    chest4.setVisibility(View.VISIBLE);

                    back1.setVisibility(View.VISIBLE);
                    back2.setVisibility(View.VISIBLE);
                    back3.setVisibility(View.VISIBLE);
                    back4.setVisibility(View.VISIBLE);

                    abs1.setVisibility(View.VISIBLE);
                    abs2.setVisibility(View.VISIBLE);
                    abs3.setVisibility(View.VISIBLE);
                    abs4.setVisibility(View.VISIBLE);


                    legs1.setVisibility(View.VISIBLE);
                    legs2.setVisibility(View.VISIBLE);
                    legs3.setVisibility(View.VISIBLE);
                    legs4.setVisibility(View.VISIBLE);


            }

            else if(selectedCategory == R.id.intermediate){
                    statusSetter.setText(category_Picked + "' s Category");
                    statusSetter.setVisibility(VISIBLE);
                    pb.setVisibility((GONE));
                    generate(chest1, ichest[getRandomNumber(0,9)]);
                    generate(chest2, ichest[getRandomNumber(0,9)]);
                    generate(chest3, ichest[getRandomNumber(0,9)]);
                    generate(chest4, ichest[getRandomNumber(0,9)]);

                    generate(back1, iback[getRandomNumber(0,8)]);
                    generate(back2, iback[getRandomNumber(0,8)]);
                    generate(back3, iback[getRandomNumber(0,8)]);
                    generate(back4, iback[getRandomNumber(0,8)]);

                    generate(abs1, iabs[getRandomNumber(0,8)]);
                    generate(abs2, iabs[getRandomNumber(0,8)]);
                    generate(abs3, iabs[getRandomNumber(0,8)]);
                    generate(abs4, iabs[getRandomNumber(0,8)]);

                    generate(legs1, ilegs[getRandomNumber(0,6)]);
                    generate(legs2, ilegs[getRandomNumber(0,6)]);
                    generate(legs3, ilegs[getRandomNumber(0,6)]);
                    generate(legs4, ilegs[getRandomNumber(0,6)]);



                    chest1.setVisibility(View.VISIBLE);
                    chest2.setVisibility(View.VISIBLE);
                    chest3.setVisibility(View.VISIBLE);
                    chest4.setVisibility(View.VISIBLE);

                    back1.setVisibility(View.VISIBLE);
                    back2.setVisibility(View.VISIBLE);
                    back3.setVisibility(View.VISIBLE);
                    back4.setVisibility(View.VISIBLE);


                    abs1.setVisibility(View.VISIBLE);
                    abs2.setVisibility(View.VISIBLE);
                    abs3.setVisibility(View.VISIBLE);
                    abs4.setVisibility(View.VISIBLE);

                    legs1.setVisibility(View.VISIBLE);
                    legs2.setVisibility(View.VISIBLE);
                    legs3.setVisibility(View.VISIBLE);
                    legs4.setVisibility(View.VISIBLE);

                }

                else if(selectedCategory == R.id.advanced){
                    pb.setVisibility((GONE));
                    statusSetter.setText(category_Picked + "' s Category");
                    statusSetter.setVisibility(VISIBLE);

                    generate(chest1, achest[getRandomNumber(0,9)]);
                    generate(chest2, achest[getRandomNumber(0,9)]);
                    generate(chest3, achest[getRandomNumber(0,9)]);
                    generate(chest4, achest[getRandomNumber(0,9)]);

                    generate(back1, aback[getRandomNumber(0,9)]);
                    generate(back2, aback[getRandomNumber(0,9)]);
                    generate(back3, aback[getRandomNumber(0,9)]);
                    generate(back4, aback[getRandomNumber(0,9)]);

                    generate(abs1, abs[getRandomNumber(0,6)]);
                    generate(abs2, abs[getRandomNumber(0,6)]);
                    generate(abs3, abs[getRandomNumber(0,6)]);
                    generate(abs4, abs[getRandomNumber(0,6)]);

                    generate(legs1, alegs[getRandomNumber(0,7)]);
                    generate(legs2, alegs[getRandomNumber(0,7)]);
                    generate(legs3, alegs[getRandomNumber(0,7)]);
                    generate(legs4, alegs[getRandomNumber(0,7)]);

                    chest1.setVisibility(View.VISIBLE);
                    chest2.setVisibility(View.VISIBLE);
                    chest3.setVisibility(View.VISIBLE);
                    chest4.setVisibility(View.VISIBLE);

                    back1.setVisibility(View.VISIBLE);
                    back2.setVisibility(View.VISIBLE);
                    back3.setVisibility(View.VISIBLE);
                    back4.setVisibility(View.VISIBLE);


                    abs1.setVisibility(View.VISIBLE);
                    abs2.setVisibility(View.VISIBLE);
                    abs3.setVisibility(View.VISIBLE);
                    abs4.setVisibility(View.VISIBLE);

                    legs1.setVisibility(View.VISIBLE);
                    legs2.setVisibility(View.VISIBLE);
                    legs3.setVisibility(View.VISIBLE);
                    legs4.setVisibility(View.VISIBLE);
                }



        }

        });




    }
    public int getRandomNumber(int min, int max) {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public TextView generate(TextView set, String got){

        set.setText(got);
        return set;


    }

}

