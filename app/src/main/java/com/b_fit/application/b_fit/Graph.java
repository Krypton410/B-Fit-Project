package com.b_fit.application.b_fit;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private float[] yData ={1, 2, 3};
    private String[] xData = {"Protein", "Fats", "Carbs"};
    PieChart pieChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_graph, container, false);
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: Creating chart");
        pieChart = (PieChart) getView().findViewById(R.id.pieChart);


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

/*
             int pos1 = e.toString().indexOf("(sum): ");
                String sales = e.toString().substring(pos1 + 7);
*/

                int pos1 = e.toString().indexOf("Entry, x:0.0 y: ");
                String infoMacro = e.toString().substring(pos1 + 18);

                for(int i=0; i < yData.length; i++){
                    if(yData[i] == Float.parseFloat(infoMacro)){
                        pos1 = i;
                        break;
                    }
                }
                String information = xData[pos1];
                Toast.makeText(getContext(), information + " " + infoMacro, Toast.LENGTH_SHORT).show();


            }



            @Override
            public void onNothingSelected() {

            }
        });


    }

    private void addDataSet() {
        Log.d(TAG, "addDataSet: STARTED ");
        ArrayList<PieEntry> yEntries = new ArrayList<>();
        ArrayList<String> xEntries = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){

            yEntries.add(new PieEntry(yData[i], i));
        }

        for(int i = 1; i < xData.length; i++){
            xEntries.add(xData[i]);

        }


        //Creating the data set
        PieDataSet pieDataSet = new PieDataSet(yEntries, "Your Macro");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(10);

        //adding color to dataset

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.parseColor("#00e676"));    //Protein
        colors.add(Color.parseColor("#9fffe0"));    //Fats
        colors.add(Color.parseColor("#00cbcc")); //Carbs


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
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
