package com.b_fit.application.b_fit;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

/**
 * Created by Maxwell on 7/7/2017.
 */

public class Graph extends Fragment implements OnChartValueSelectedListener{
    private static String TAG = "GRAPH";
    float[] yData;
    public String[] xData = {"Protein", "Fats", "Carbs"};
    PieChart pieChart, pieChartMeal;
    Spinner goal, meal;
    String  formula_Male, formula_Female;
    float fatGain, fatLoss, carbGain, carbLoss;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_graph, container, false);
        return rootView;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(null);



        formula_Male = String.valueOf(round(66 + (13.7 * /*Weight*/ Double.valueOf(DataHolder.getWeight()))
                + (5 *   /*Height*/ (DataHolder.getFeet()*30.48) + (DataHolder.getInch()*2.54))
                - (6.8 * DataHolder.getAge()),4));
        formula_Female = (String.valueOf(round(655 + (9.6 * Double.valueOf(DataHolder.getWeight()))
                + (1.8 * DataHolder.getFeet()*30.48) + (DataHolder.getInch()*2.54)
                - (4.7 * DataHolder.getAge()),4)));


        meal = (Spinner) getView().findViewById(R.id.meal);
        goal = (Spinner) getView().findViewById(R.id.goal);





        goal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (goal.getSelectedItemPosition() == 0) {//Gain

                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChart = (PieChart) getView().findViewById(R.id.pieChart);

                    yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein())))//Protein Fats Carbs
                            , Math.round(Float.valueOf((DataHolder.getGainFat())))
                            , Math.round(Float.valueOf((DataHolder.getGainCarb())))};

                    pieChart.setDescription(null);
                    pieChart.setRotationEnabled(true);
                    pieChart.setHoleRadius(20);
                    pieChart.setCenterText("Macro");
                    pieChart.setTransparentCircleAlpha(5);
                    pieChart.setDrawEntryLabels(true);
                    addDataSet();
                    pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());


                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String info = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(info)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String information;
                            try{information = xData[pos1];}
                            catch (ArrayIndexOutOfBoundsException v)
                            {information = xData[pos1+1];}
                            Toast.makeText(getContext(), information + " " + info + " g", Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void onNothingSelected() {}});}


                else if (goal.getSelectedItemPosition() == 1) {//Maintain
                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChart = (PieChart) getView().findViewById(R.id.pieChart);

                    yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein())))
                            , Math.round(Float.valueOf(String.valueOf(DataHolder.getFats())))
                            , Math.round(Float.valueOf(String.valueOf(DataHolder.getCarbs())))};

                    pieChart.setDescription(null);
                    pieChart.setRotationEnabled(true);
                    pieChart.setHoleRadius(20);
                    pieChart.setCenterText("Macro");
                    pieChart.setTransparentCircleAlpha(5);
                    pieChart.setDrawEntryLabels(true);

                    addDataSet();

                    pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());


                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String info = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(info)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String information;
                            try{information = xData[pos1];}
                            catch (ArrayIndexOutOfBoundsException v)
                            {information = xData[pos1+1];}
                            Toast.makeText(getContext(), information + " " + info + " g", Toast.LENGTH_SHORT).show();
                        }


                        @Override
                        public void onNothingSelected() {}});}

                else if (goal.getSelectedItemPosition() == 2) {//Loss
                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChart = (PieChart) getView().findViewById(R.id.pieChart);

                    yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein())))
                            , Math.round(Float.valueOf((DataHolder.getLossFat())))
                            , Math.round(Float.valueOf((DataHolder.getLossCarb())))};

                    pieChart.setDescription(null);
                    pieChart.setRotationEnabled(true);
                    pieChart.setHoleRadius(20);
                    pieChart.setCenterText("Macro");
                    pieChart.setTransparentCircleAlpha(5);
                    pieChart.setDrawEntryLabels(true);

                    addDataSet();


                    pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());



                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String info = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(info)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String information;
                            try{information = xData[pos1];}
                            catch (ArrayIndexOutOfBoundsException v)
                            {information = xData[pos1+1];}
                            Toast.makeText(getContext(), information + " " + info + " g", Toast.LENGTH_SHORT).show();}


                        @Override
                        public void onNothingSelected() {
                        }});
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        meal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(meal.getSelectedItemPosition() == 0){//1 meal
                    //pieChart for meal
                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChartMeal = (PieChart) getView().findViewById(R.id.pieChart2);



                    if(goal.getSelectedItemPosition() == 0){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein())))//Protein Fats Carbs
                                , Math.round(Float.valueOf((DataHolder.getGainFat())))
                                , Math.round(Float.valueOf((DataHolder.getGainCarb())))};
                    }//gain
                    else if(goal.getSelectedItemPosition() == 1){
                             yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein())))
                            , Math.round(Float.valueOf(String.valueOf(DataHolder.getFats())))
                            , Math.round(Float.valueOf(String.valueOf(DataHolder.getCarbs())))};
                    }//Maintain
                    else if(goal.getSelectedItemPosition() == 2){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein())))
                                , Math.round(Float.valueOf((DataHolder.getLossFat())))
                                , Math.round(Float.valueOf((DataHolder.getLossCarb())))};
                    }//Loss


                    pieChartMeal.setDescription(null);
                    pieChartMeal.setRotationEnabled(true);
                    pieChartMeal.setHoleRadius(20);
                    pieChartMeal.setCenterText("Meal");
                    pieChartMeal.setTransparentCircleAlpha(5);
                    pieChartMeal.setDrawEntryLabels(true);
                    addDataSetForMeal();
                    pieChartMeal.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());



                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String infoMeal = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMeal)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String informationMeal = xData[pos1];
                            Toast.makeText(getContext(), informationMeal + " " + infoMeal + " g / meal", Toast.LENGTH_SHORT).show();}


                        @Override
                        public void onNothingSelected() {
                        }});
                }

                else if(meal.getSelectedItemPosition() == 1){//2 meals a day
                    //pieChart for meal
                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChartMeal = (PieChart) getView().findViewById(R.id.pieChart2);
                    if(goal.getSelectedItemPosition() == 0){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()))/2f)//Protein Fats Carbs
                                , Math.round(Float.valueOf((DataHolder.getGainFat()))/2f)
                                , Math.round(Float.valueOf((DataHolder.getGainCarb()))/2f)};
                    }//gain
                    else if(goal.getSelectedItemPosition() == 1){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()))/2f)
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getFats()))/2f)
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getCarbs()))/2f)};
                    }//Maintain
                    else if(goal.getSelectedItemPosition() == 2){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()))/2f)
                                , Math.round(Float.valueOf((DataHolder.getLossFat()))/2f)
                                , Math.round(Float.valueOf((DataHolder.getLossCarb()))/2f)};
                    }//Loss

                    pieChartMeal.setDescription(null);
                    pieChartMeal.setRotationEnabled(true);
                    pieChartMeal.setHoleRadius(20);
                    pieChartMeal.setCenterText("Meal");
                    pieChartMeal.setTransparentCircleAlpha(5);
                    pieChartMeal.setDrawEntryLabels(true);
                    addDataSetForMeal();
                    pieChartMeal.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());



                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String infoMeal = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMeal)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String informationMeal;
                            informationMeal = xData[pos1];

                            Toast.makeText(getContext(), informationMeal + " " + infoMeal + " g / meal", Toast.LENGTH_SHORT).show();}


                        @Override
                        public void onNothingSelected() {
                        }});
                }
                else if(meal.getSelectedItemPosition() == 2){//3 Meals

                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChartMeal = (PieChart) getView().findViewById(R.id.pieChart2);

                    if(goal.getSelectedItemPosition() == 0){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/3)))//Protein Fats Carbs
                                , Math.round(Float.valueOf((DataHolder.getGainFat()/3f)))
                                , Math.round(Float.valueOf((DataHolder.getGainCarb()/3f)))};
                    }//gain
                    else if(goal.getSelectedItemPosition() == 1){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/3f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getFats()/3f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getCarbs()/3f)))};
                    }//Maintain
                    else if(goal.getSelectedItemPosition() == 2){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/3f)))
                                , Math.round(Float.valueOf((DataHolder.getLossFat()/3f)))
                                , Math.round(Float.valueOf((DataHolder.getLossCarb()/3f)))};
                    }//Loss

                    pieChartMeal.setDescription(null);
                    pieChartMeal.setRotationEnabled(true);
                    pieChartMeal.setHoleRadius(20);
                    pieChartMeal.setCenterText("Meal");
                    pieChartMeal.setTransparentCircleAlpha(5);
                    pieChartMeal.setDrawEntryLabels(true);
                    addDataSetForMeal();
                    pieChartMeal.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());



                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String infoMeal = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMeal)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String informationMeal = xData[pos1];
                            Toast.makeText(getContext(), informationMeal + " " + infoMeal + " g / meal", Toast.LENGTH_SHORT).show();}


                        @Override
                        public void onNothingSelected() {
                        }});

                }

                else if(meal.getSelectedItemPosition() == 3){ // 4 meals a day

                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChartMeal = (PieChart) getView().findViewById(R.id.pieChart2);

                    if(goal.getSelectedItemPosition() == 0){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/4f)))//Protein Fats Carbs
                                , Math.round(Float.valueOf((DataHolder.getGainFat()/4f)))
                                , Math.round(Float.valueOf((DataHolder.getGainCarb()/4f)))};
                    }//gain
                    else if(goal.getSelectedItemPosition() == 1){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/4f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getFats()/4f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getCarbs()/4f)))};
                    }//Maintain
                    else if(goal.getSelectedItemPosition() == 2){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/4f)))
                                , Math.round(Float.valueOf((DataHolder.getLossFat()/4f)))
                                , Math.round(Float.valueOf((DataHolder.getLossCarb()/4f)))};
                    }//Loss

                    pieChartMeal.setDescription(null);
                    pieChartMeal.setRotationEnabled(true);
                    pieChartMeal.setHoleRadius(20);
                    pieChartMeal.setCenterText("Meal");
                    pieChartMeal.setTransparentCircleAlpha(5);
                    pieChartMeal.setDrawEntryLabels(true);
                    addDataSetForMeal();
                    pieChartMeal.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());



                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String infoMeal = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMeal)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String informationMeal = xData[pos1];
                            Toast.makeText(getContext(), informationMeal + " " + infoMeal + " g / meal", Toast.LENGTH_SHORT).show();
                        }


                        @Override
                        public void onNothingSelected() {
                        }});

                }

                else if(meal.getSelectedItemPosition() == 4){//5 meals

                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChartMeal = (PieChart) getView().findViewById(R.id.pieChart2);
                    if(goal.getSelectedItemPosition() == 0){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/5f)))//Protein Fats Carbs
                                , Math.round(Float.valueOf((DataHolder.getGainFat()/5f)))
                                , Math.round(Float.valueOf((DataHolder.getGainCarb()/5f)))};
                    }//gain
                    else if(goal.getSelectedItemPosition() == 1){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/5f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getFats()/5f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getCarbs()/5f)))};
                    }//Maintain
                    else if(goal.getSelectedItemPosition() == 2){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/5f)))
                                , Math.round(Float.valueOf((DataHolder.getLossFat()/5f)))
                                , Math.round(Float.valueOf((DataHolder.getLossCarb()/5f)))};
                    }//Loss




                    pieChartMeal.setDescription(null);
                    pieChartMeal.setRotationEnabled(true);
                    pieChartMeal.setHoleRadius(20);
                    pieChartMeal.setCenterText("Meal");
                    pieChartMeal.setTransparentCircleAlpha(5);
                    pieChartMeal.setDrawEntryLabels(true);
                    addDataSetForMeal();
                    pieChartMeal.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());



                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String infoMeal = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMeal)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String informationMeal = xData[pos1];
                            Toast.makeText(getContext(), informationMeal + " " + infoMeal+ " g / meal", Toast.LENGTH_SHORT).show();}


                        @Override
                        public void onNothingSelected() {
                        }});
                }

                else if(meal.getSelectedItemPosition() == 5){//6 meals

                    Log.d(TAG, "onActivityCreated: Creating 6 meals");
                    pieChartMeal = (PieChart) getView().findViewById(R.id.pieChart2);

                    if(goal.getSelectedItemPosition() == 0){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/6f)))//Protein Fats Carbs
                                , Math.round(Float.valueOf((DataHolder.getGainFat()/6f)))
                                , Math.round(Float.valueOf((DataHolder.getGainCarb()/6f)))};
                    }//gain
                    else if(goal.getSelectedItemPosition() == 1){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/6f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getFats()/6f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getCarbs()/6f)))};
                    }//Maintain
                    else if(goal.getSelectedItemPosition() == 2){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein())))
                                , Math.round(Float.valueOf((DataHolder.getLossFat()/6f)))
                                , Math.round(Float.valueOf((DataHolder.getLossCarb()/6f)))};
                    }//Loss

                    pieChartMeal.setDescription(null);
                    pieChartMeal.setRotationEnabled(true);
                    pieChartMeal.setHoleRadius(20);
                    pieChartMeal.setCenterText("Meal");
                    pieChartMeal.setTransparentCircleAlpha(5);
                    pieChartMeal.setDrawEntryLabels(true);
                    addDataSetForMeal();
                    pieChartMeal.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());



                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String infoMeal = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMeal)){
                                    pos1 = i;
                                    break;
                                }

                            }
                           String informationMeal = xData[pos1];
                            Toast.makeText(getContext(), informationMeal + " " + infoMeal + " g / meal", Toast.LENGTH_SHORT).show();
                        }


                        @Override
                        public void onNothingSelected() {}});

                     }


                     else if(meal.getSelectedItemPosition() == 6){//7 meals


                    Log.d(TAG, "onActivityCreated: Creating chart");
                    pieChartMeal = (PieChart) getView().findViewById(R.id.pieChart2);

                    if(goal.getSelectedItemPosition() == 0){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/7f)))//Protein Fats Carbs
                                , Math.round(Float.valueOf((DataHolder.getGainFat()/7f)))
                                , Math.round(Float.valueOf((DataHolder.getGainCarb()/7f)))};
                    }//gain
                    else if(goal.getSelectedItemPosition() == 1){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/7f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getFats()/7f)))
                                , Math.round(Float.valueOf(String.valueOf(DataHolder.getCarbs()/7f)))};
                    }//Maintain
                    else if(goal.getSelectedItemPosition() == 2){
                        yData = new float[] {Math.round(Float.valueOf(String.valueOf(DataHolder.getProtein()/7f)))
                                , Math.round(Float.valueOf((DataHolder.getLossFat()/7f)))
                                , Math.round(Float.valueOf((DataHolder.getLossCarb()/7f)))};

                    }//Loss



                    pieChartMeal.setDescription(null);
                    pieChartMeal.setRotationEnabled(true);
                    pieChartMeal.setHoleRadius(20);
                    pieChartMeal.setCenterText("Meal");
                    pieChartMeal.setTransparentCircleAlpha(5);
                    pieChartMeal.setDrawEntryLabels(true);
                    addDataSetForMeal();
                    pieChartMeal.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry e, Highlight h) {
                            Log.d(TAG, "onValueSelected: Value Selected ");
                            Log.d(TAG, "onValueSelected: " + e.toString());
                            Log.d(TAG, "onValueSelectedForH: " + h.toString());



                            int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                            String infoMeal = e.toString().substring(pos1 + 18);

                            for(int i=0; i < xData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMeal)){
                                    pos1 = i;

                                    break;
                                }
                            }
                            String informationMeal = xData[pos1];
                            Toast.makeText(getContext(), informationMeal + " " + infoMeal+ " g / meal", Toast.LENGTH_SHORT).show();}


                        @Override
                        public void onNothingSelected() {
                        }});

                     }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });












    }


    private void addDataSetForMeal() {
        Log.d(TAG, "addDataSetForMeal: STARTED ");
        ArrayList<PieEntry> yEntries = new ArrayList<>();
        ArrayList<String> xEntries = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntries.add(new PieEntry(yData[i], i));}

        for(int i = 1; i < xData.length; i++){
            xEntries.add(xData[i]);}


        //Creating the data set
        PieDataSet pieDataSet = new PieDataSet(yEntries, "");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(10);


        //adding color to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#a30000"));    //Protein
        colors.add(Color.parseColor("#ff9800"));    //Fats
        colors.add(Color.parseColor("#004c40")); //Carbs
        pieDataSet.setColors(colors);
        Legend legend = pieChartMeal.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);

        //Creating pie data

        PieData pieDataMeal = new PieData(pieDataSet);
        pieChartMeal.setData(pieDataMeal);
        pieChartMeal.invalidate();

    }

    private void addDataSet() {
        Log.d(TAG, "addDataSet: STARTED ");
        ArrayList<PieEntry> yEntries = new ArrayList<>();
        ArrayList<String> xEntries = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntries.add(new PieEntry(yData[i], i));}

        for(int i = 1; i < xData.length; i++){
            xEntries.add(xData[i]);}


        //Creating the data set
        PieDataSet pieDataSet = new PieDataSet(yEntries, "");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(10);

        //adding color to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#f57f17"));    //Protein
        colors.add(Color.parseColor("#bc5100"));    //Fats
        colors.add(Color.parseColor("#ffd180")); //Carbs
        pieDataSet.setColors(colors);
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER/*ABOVE_CHART_CENTER*/);

        //Creating pie data

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {}

    @Override
    public void onNothingSelected() {}




    @Override
    public void onResume(){
        super.onResume();
        super.onActivityCreated(null);
        this.onCreate(null);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }



}
