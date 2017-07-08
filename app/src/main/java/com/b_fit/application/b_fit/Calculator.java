package com.b_fit.application.b_fit;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class Calculator extends Fragment{

    SharedPreferences pref, pref2;
    SharedPreferences.Editor editor;
    TextView theBmr, tci, bms, waterIntake, weightLoss, weightGain, theProtein;
    Spinner routine;
    String formula_Male, formula_Female, theRoutine;
    Button infoBmr;
    String spRoutine;
    float carbs, fats, protein, gainCarb, gainFat, lossCarb, lossFat, gain, loss;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);
            return rootView;
        }


        @Override
        public void onActivityCreated(Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);
            weightLoss = (TextView) getView().findViewById(R.id.weightLoss);
            weightGain = (TextView) getView().findViewById(R.id.weightGain);
            theBmr = (TextView) getView().findViewById(R.id.bmr);
            routine = (Spinner) getView().findViewById(R.id.spinner);
            tci = (TextView) getView().findViewById(R.id.tci);

            bms = (TextView)getView().findViewById(R.id.bms);
            waterIntake = (TextView) getView().findViewById(R.id.water);
            formula_Male = String.valueOf(round(66 + (13.7 * /*Weight*/ Double.valueOf(DataHolder.getWeight()))
                    + (5 *   /*Height*/ (DataHolder.getFeet()*30.48) + (DataHolder.getInch()*2.54))
                    - (6.8 * DataHolder.getAge()),4));
            formula_Female = (String.valueOf(round(655 + (9.6 * Double.valueOf(DataHolder.getWeight()))
                    + (1.8 * DataHolder.getFeet()*30.48) + (DataHolder.getInch()*2.54)
                    - (4.7 * DataHolder.getAge()),4)));
            //Formula Male & Female are BMR

            theProtein = (TextView) getView().findViewById(R.id.theProtein);




            if(DataHolder.getGender().equals("Male")){

                theBmr.setText(formula_Male);

            }
            else if(DataHolder.getGender().equals("Female")){

                theBmr.setText(formula_Female);
            }

            theProtein.setText(String.valueOf((Double.valueOf(DataHolder.getWeight()) * 2.204) * .825));
            protein = Float.valueOf(theProtein.getText().toString());

                try{routine.setSelection(Integer.valueOf(DataHolder.getTraining()));}
                catch (Exception e){/*routine.setSelection(Integer.valueOf(DataHolder.getTraining()));*/}
                routine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                        if(routine.getSelectedItemPosition() == 0) {

                            tci.setText("No Data Displayed");
                            weightLoss.setText("No Data to Display");
                            weightGain.setText("No Data to Display");


                            fats = Math.round(Float.valueOf(formula_Male) * 0.0f)
                                    * 0.25f /9f;

                            carbs = (Math.round(Double.valueOf(formula_Male) * 0.0f)) - (fats + protein);


                            gainCarb = 0.0f; gainFat = 0.0f; lossCarb = 0.0f; lossFat = 0.0f;
                            DataHolder.setGainCarb(gainCarb);
                            DataHolder.setGainFat(gainFat);
                            DataHolder.setLossCarb(lossCarb);
                            DataHolder.setLossFat(lossFat);



                            DataHolder.setProtein(protein);
                            DataHolder.setCarbs(carbs);
                            DataHolder.setFats(fats);
                            theRoutine =  String.valueOf(routine.getSelectedItemPosition());
                            pref = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            editor = pref.edit();
                            editor.putString("theRoutine", theRoutine);
                            editor.apply();
                            editor.commit();
                            pref2 = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            spRoutine = pref2.getString("theRoutine", theRoutine);
                            DataHolder.setTraining(spRoutine);

                        }

                        else if(routine.getSelectedItemPosition() == 1){

                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.2)) + "Cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.2)
                                - (Math.round(Double.valueOf(formula_Male) * 1.2) * 0.20)) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.2)
                                + (Math.round(Double.valueOf(formula_Male) * 1.2) * 0.20)) + " Cal");

                                fats = Math.round(Float.valueOf(formula_Male) * 1.2f)
                                        * 0.25f / 9f;
                                carbs = (Math.round(Double.valueOf(formula_Male) * 1.2f)) - (fats + protein);


                                gain = Math.round(Float.valueOf(formula_Male) * 1.2f)
                                + (Math.round(Float.valueOf(formula_Male) * 1.2f) * 0.20f);

                                loss = Math.round(Float.valueOf(formula_Male) * 1.2f)
                                - (Math.round(Float.valueOf(formula_Male) * 1.2f) * 0.20f);

                                gainFat = Math.round(((gain * 1.2f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.2f) * 0.25f) / 9f);

                                gainCarb = Math.round((gain * 1.2f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.2f) - (lossFat + protein));




                            }
                            else
                            {

                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.2)));
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.2)
                                - (Math.round(Double.valueOf(formula_Female) * 1.2) * 0.20)) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.2)
                                + (Math.round(Double.valueOf(formula_Female) * 1.2) * 0.20)) + " Cal");

                                fats = Math.round(Float.valueOf(formula_Female) * 1.2f)
                                        * 0.25f / 9f;

                                carbs = (Math.round(Double.valueOf(formula_Female) * 1.2f)) - (fats + protein);
                                gain = Math.round(Float.valueOf(formula_Female) * 1.2f)
                                        + (Math.round(Float.valueOf(formula_Female) * 1.2f) * 0.20f);
                                loss = Math.round(Float.valueOf(formula_Female) * 1.2f)
                                        - (Math.round(Float.valueOf(formula_Female) * 1.2f) * 0.20f);
                                gainFat = Math.round(((gain * 1.2f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.2f) * 0.25f) / 9f);

                                gainCarb = Math.round((gain * 1.2f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.2f) - (lossFat + protein));


                            }
                            DataHolder.setGainCarb(gainCarb);
                            DataHolder.setGainFat(gainFat);
                            DataHolder.setLossCarb(lossCarb);
                            DataHolder.setLossFat(lossFat);
                            DataHolder.setProtein(protein);
                            DataHolder.setCarbs(carbs);
                            DataHolder.setFats(fats);
                            theRoutine =  String.valueOf(routine.getSelectedItemPosition());
                            pref = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            editor = pref.edit();
                            editor.putString("theRoutine", theRoutine);
                            editor.apply();
                            editor.commit();
                            pref2 = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            spRoutine = pref2.getString("theRoutine", theRoutine);
                            DataHolder.setTraining(spRoutine);

                        }


                        else if(routine.getSelectedItemPosition() == 2){

                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.375)) + " cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.375)
                                - (Math.round(Double.valueOf(formula_Male) * 1.375 * 0.20))) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.375)
                                + (Math.round(Double.valueOf(formula_Male) * 1.375 * 0.20))) + " Cal");
                                fats = Math.round(Float.valueOf(formula_Male) * 1.375f)
                                        * 0.25f / 9f;
                                carbs = (Math.round(Double.valueOf(formula_Male) * 1.375f)) - (fats + protein);
                                gain = Math.round(Float.valueOf(formula_Male) * 1.375f)
                                        + (Math.round(Float.valueOf(formula_Male) * 1.375f) * 0.20f);
                                loss = Math.round(Float.valueOf(formula_Male) * 1.375f)
                                        - (Math.round(Float.valueOf(formula_Male) * 1.375f) * 0.20f);
                                gainFat = Math.round(((gain * 1.375f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.375f) * 0.25f) / 9f);
                                gainCarb = Math.round((gain * 1.375f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.375f) - (lossFat + protein));

                            }
                            else
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.375)) + " cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.375)
                                        - (Math.round(Double.valueOf(formula_Female) * 1.375 * 0.20))) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.375)
                                        + (Math.round(Double.valueOf(formula_Female) * 1.375 * 0.20))) + " Cal");

                                fats = Math.round(Float.valueOf(formula_Female) * 1.375f)
                                        * 0.25f / 9f;
                                carbs = (Math.round(Double.valueOf(formula_Female) * 1.375f)) - (fats + protein);
                                carbs = (Math.round(Double.valueOf(formula_Female) * 1.375f)) - (fats + protein);
                                gain = Math.round(Float.valueOf(formula_Female) * 1.375f)
                                        + (Math.round(Float.valueOf(formula_Female) * 1.375f) * 0.20f);
                                loss = Math.round(Float.valueOf(formula_Female) * 1.375f)
                                        - (Math.round(Float.valueOf(formula_Female) * 1.375f) * 0.20f);
                                gainFat = Math.round(((gain * 1.375f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.375f) * 0.25f) / 9f);

                                gainCarb = Math.round((gain * 1.375f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.375f) - (lossFat + protein));

                            }
                            DataHolder.setGainCarb(gainCarb);
                            DataHolder.setGainFat(gainFat);
                            DataHolder.setLossCarb(lossCarb);
                            DataHolder.setLossFat(lossFat);
                            DataHolder.setProtein(protein);
                            DataHolder.setCarbs(carbs);
                            DataHolder.setFats(fats);
                            theRoutine =  String.valueOf(routine.getSelectedItemPosition());
                            pref = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            editor = pref.edit();
                            editor.putString("theRoutine", theRoutine);
                            editor.apply();
                            editor.commit();
                            pref2 = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            spRoutine = pref2.getString("theRoutine", theRoutine);
                            DataHolder.setTraining(spRoutine);
                        }

                        else if(routine.getSelectedItemPosition() == 3){
                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.55)) + " cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.55)
                                        - (Math.round(Double.valueOf(formula_Male) * 1.55 * 0.20))) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.55)
                                        + (Math.round(Double.valueOf(formula_Male) * 1.55 * 0.20))) + " Cal");




                                fats = Math.round(Float.valueOf(formula_Male) * 1.55f)
                                        * 0.25f / 9f;
                                carbs = (Math.round(Double.valueOf(formula_Male) * 1.55f)) - (fats + protein);

                                gain = Math.round(Float.valueOf(formula_Male) * 1.55f) //WEIGHT gain FORMULA
                                        + (Math.round(Float.valueOf(formula_Male) * 1.55f) * 0.20f); // WEIGHT LOSS FORMULA
                                loss = Math.round(Float.valueOf(formula_Male) * 1.55f)
                                        - (Math.round(Float.valueOf(formula_Male) * 1.55f) * 0.20f);
                                gainFat = Math.round(((gain * 1.55f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.55f) * 0.25f) / 9f);

                                gainCarb = Math.round((gain * 1.55f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.55f) - (lossFat + protein));

                            }
                            else
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.55)) + " cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.55)
                                        - (Math.round(Double.valueOf(formula_Female) * 1.55 * 0.20))) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.55)
                                        + (Math.round(Double.valueOf(formula_Female) * 1.55 * 0.20))) + " Cal");

                                fats = Math.round(Float.valueOf(formula_Female) * 1.55f)
                                        * 0.25f / 9f;

                                carbs = (Math.round(Double.valueOf(formula_Female) * 1.55f)) - (fats + protein);

                                gain = Math.round(Float.valueOf(formula_Female) * 1.55f)
                                        + (Math.round(Float.valueOf(formula_Female) * 1.55f) * 0.20f);
                                loss = Math.round(Float.valueOf(formula_Female) * 1.55f)
                                        - (Math.round(Float.valueOf(formula_Female) * 1.55f) * 0.20f);
                                gainFat = Math.round(((gain * 1.55f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.55f) * 0.25f) / 9f);

                                gainCarb = Math.round((gain * 1.55f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.55f) - (lossFat + protein));

                            }
                            DataHolder.setGainCarb(gainCarb);
                            DataHolder.setGainFat(gainFat);
                            DataHolder.setLossCarb(lossCarb);
                            DataHolder.setLossFat(lossFat);
                            DataHolder.setProtein(protein);
                            DataHolder.setCarbs(carbs);
                            DataHolder.setFats(fats);
                            theRoutine =  String.valueOf(routine.getSelectedItemPosition());
                            pref = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            editor = pref.edit();
                            editor.putString("theRoutine", theRoutine);
                            editor.apply();
                            editor.commit();
                            pref2 = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            spRoutine = pref2.getString("theRoutine", theRoutine);
                            DataHolder.setTraining(spRoutine);
                        }

                        else if(routine.getSelectedItemPosition() == 4){
                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.725)) + " cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.725)
                                        - (Math.round(Double.valueOf(formula_Male) * 1.725 * 0.20))) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.725)
                                        + (Math.round(Double.valueOf(formula_Male) * 1.725 * 0.20))) + " Cal");

                                fats = Math.round(Float.valueOf(formula_Male) * 1.725f)
                                        * 0.25f / 9f;

                                carbs = (Math.round(Double.valueOf(formula_Male) * 1.725f)) - (fats + protein);

                                gain = Math.round(Float.valueOf(formula_Male) * 1.725f)
                                        + (Math.round(Float.valueOf(formula_Male) * 1.725f) * 0.20f);
                                loss = Math.round(Float.valueOf(formula_Male) * 1.725f)
                                        - (Math.round(Float.valueOf(formula_Male) * 1.725f) * 0.20f);
                                gainFat = Math.round(((gain * 1.725f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.725f) * 0.25f) / 9f);

                                gainCarb = Math.round((gain * 1.725f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.725f) - (lossFat + protein));

                            }
                            else
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.725)) + " cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.725)
                                        - (Math.round(Double.valueOf(formula_Female) * 1.725 * 0.20))) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.725)
                                        + (Math.round(Double.valueOf(formula_Female) * 1.725 * 0.20))) + " Cal");

                                fats = Math.round(Float.valueOf(formula_Female) * 1.725f)
                                        * 0.25f / 9f;

                                carbs = (Math.round(Double.valueOf(formula_Female) * 1.725f)) - (fats + protein);

                                gain = Math.round(Float.valueOf(formula_Female) * 1.725f)
                                        + (Math.round(Float.valueOf(formula_Female) * 1.725f) * 0.20f);
                                loss = Math.round(Float.valueOf(formula_Female) * 1.725f)
                                        - (Math.round(Float.valueOf(formula_Female) * 1.725f) * 0.20f);
                                gainFat = Math.round(((gain * 1.725f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.725f) * 0.25f) / 9f);

                                gainCarb = Math.round((gain * 1.725f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.725f) - (lossFat + protein));


                            }
                            DataHolder.setGainCarb(gainCarb);
                            DataHolder.setGainFat(gainFat);
                            DataHolder.setLossCarb(lossCarb);
                            DataHolder.setLossFat(lossFat);
                            DataHolder.setProtein(protein);
                            DataHolder.setCarbs(carbs);
                            DataHolder.setFats(fats);
                            theRoutine =  String.valueOf(routine.getSelectedItemPosition());
                            pref = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            editor = pref.edit();
                            editor.putString("theRoutine", theRoutine);
                            editor.apply();
                            editor.commit();
                            pref2 = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            spRoutine = pref2.getString("theRoutine", theRoutine);
                            DataHolder.setTraining(spRoutine);
                        }

                        else if(routine.getSelectedItemPosition() == 5){
                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.9)) + " cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.9)
                                        - (Math.round(Double.valueOf(formula_Male) * 1.9 * 0.20))) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Male) * 1.9)
                                        + (Math.round(Double.valueOf(formula_Male) * 1.9 * 0.20))) + " Cal");


                                fats = Math.round(Float.valueOf(formula_Male) * 1.9f)
                                        * 0.25f / 9f;

                                carbs = (Math.round(Double.valueOf(formula_Male) * 1.9f)) - (fats + protein);

                                gain = Math.round(Float.valueOf(formula_Male) * 1.9f)
                                        + (Math.round(Float.valueOf(formula_Male) * 1.9f) * 0.20f);
                                loss = Math.round(Float.valueOf(formula_Male) * 1.9f)
                                        - (Math.round(Float.valueOf(formula_Male) * 1.9f) * 0.20f);
                                gainFat = Math.round(((gain * 1.9f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.9f) * 0.25f) / 9f);

                                gainCarb = Math.round((gain * 1.9f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.9f) - (lossFat + protein));

                            }
                            else
                            {
                                tci.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.9)) + " cal");
                                weightLoss.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.9)
                                        - (Math.round(Double.valueOf(formula_Female) * 19 * 0.20))) + " Cal");
                                weightGain.setText(String.valueOf(Math.round(Double.valueOf(formula_Female) * 1.9)
                                        + (Math.round(Double.valueOf(formula_Female) * 1.9 * 0.20))) + " Cal");


                                fats = Math.round(Float.valueOf(formula_Female) * 1.9f)
                                        * 0.25f / 9f;

                                carbs = (Math.round(Double.valueOf(formula_Female) * 1.9f)) - (fats + protein);

                                gain = Math.round(Float.valueOf(formula_Female) * 1.9f) //Getting Gain Val into Variable
                                        + (Math.round(Float.valueOf(formula_Female) * 1.9f) * 0.20f);
                                loss = Math.round(Float.valueOf(formula_Female) * 1.9f)
                                        - (Math.round(Float.valueOf(formula_Female) * 1.9f) * 0.20f);

                                gainFat = Math.round(((gain * 1.9f) * 0.25f) / 9f);
                                lossFat = Math.round(((loss * 1.9f) * 0.25f) / 9f);
                                gainCarb = Math.round((gain * 1.9f) - (gainFat + protein));
                                lossCarb = Math.round((loss * 1.9f) - (lossFat + protein));
                            }


                            DataHolder.setGainCarb(gainCarb);
                            DataHolder.setGainFat(gainFat);
                            DataHolder.setLossCarb(lossCarb);
                            DataHolder.setLossFat(lossFat);
                            DataHolder.setProtein(protein);
                            DataHolder.setCarbs(carbs);
                            DataHolder.setFats(fats);
                            theRoutine =  String.valueOf(routine.getSelectedItemPosition());
                            pref = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            editor = pref.edit();
                            editor.putString("theRoutine", theRoutine);
                            editor.apply();
                            editor.commit();
                            pref2 = getActivity().getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                            spRoutine = pref2.getString("theRoutine", theRoutine);
                            DataHolder.setTraining(spRoutine);
                        }






                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}});









            Double feetToMeters = (Double.valueOf(DataHolder.getFeet())*12)*0.025;
            Double inchToMeters = (Double.valueOf(DataHolder.getInch()))*0.025;
            Double weight = Double.valueOf(DataHolder.getWeight());
            Double squaredMeters = (feetToMeters + inchToMeters)*(feetToMeters + inchToMeters);
            //Body Mass Status
            Double bmi = (weight / squaredMeters);

            bms.setText(String.valueOf(round(bmi, 3)));
            waterIntake.setText(String.valueOf(Double.valueOf(DataHolder.getWeight())*(2.205)*(0.5)) + " Oz / " +
                    String.valueOf(Math.round(Double.valueOf(DataHolder.getWeight())*(2.205)*(0.5)/8)) + " Cups");





            }




    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


        }


