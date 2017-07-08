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
    private String[] xData = {"Protein", "Fats", "Carbs"};
    PieChart pieChart;
    Spinner goal;
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
                            String infoMacro = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMacro)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String information = xData[pos1];
                            Toast.makeText(getContext(), information + " " + infoMacro + " g", Toast.LENGTH_SHORT).show();


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
                            String infoMacro = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMacro)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String information = xData[pos1];
                            Toast.makeText(getContext(), information + " " + infoMacro + " g", Toast.LENGTH_SHORT).show();
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
                            String infoMacro = e.toString().substring(pos1 + 18);

                            for(int i=0; i < yData.length; i++){
                                if(yData[i] == Float.parseFloat(infoMacro)){
                                    pos1 = i;
                                    break;
                                }
                            }
                            String information = xData[pos1];
                            Toast.makeText(getContext(), information + " " + infoMacro + " g", Toast.LENGTH_SHORT).show();}


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
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);

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
