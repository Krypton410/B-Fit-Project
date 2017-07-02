package com.b_fit.application.b_fit;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class Calculator extends Fragment{

    TextView theBmr, tci;
    Spinner routine;
    String formula_Male, formula_Female;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);
            return rootView;
        }


        @Override
        public void onActivityCreated(Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);
            theBmr = (TextView) getView().findViewById(R.id.bmr);
            routine = (Spinner) getView().findViewById(R.id.spinner);
            tci = (TextView) getView().findViewById(R.id.tci);

            formula_Male = String.valueOf(66 + (13.7 * /*Weight*/ Double.valueOf(DataHolder.getWeight()))
                    + (5 *   /*Height*/ (DataHolder.getFeet()*30.48) + (DataHolder.getInch()*2.54))
                    - (6.8 * DataHolder.getAge()));
            formula_Female = (String.valueOf(655 + (9.6 * Double.valueOf(DataHolder.getWeight()))
                    + (1.8 * DataHolder.getFeet()*30.48) + (DataHolder.getInch()*2.54)
                    - (4.7 * DataHolder.getAge())));

            if(DataHolder.getGender().equals("Male")){

                theBmr.setText(formula_Male);

            }
            else if(DataHolder.getGender().equals("Female")){

                theBmr.setText(formula_Female);
            }



                routine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(routine.getSelectedItemPosition() == 0){
                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Male) * 1.2));
                            }
                            else
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Female) * 1.2));
                            }
                        }
                        if(routine.getSelectedItemPosition() == 1){
                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Male) * 1.375));
                            }
                            else
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Female) * 1.375));
                            }
                        }

                        if(routine.getSelectedItemPosition() == 2){
                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Male) * 1.55));
                            }
                            else
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Female) * 1.55));
                            }
                        }

                        if(routine.getSelectedItemPosition() == 3){
                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Male) * 1.725));
                            }
                            else
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Female) * 1.725));
                            }
                        }

                        if(routine.getSelectedItemPosition() == 4){
                            if(DataHolder.getGender().equals("Male"))
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Male) * 1.9));
                            }
                            else
                            {
                                tci.setText(String.valueOf(Double.valueOf(formula_Female) * 1.9));
                            }
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });


            }






        }


