package com.b_fit.application.b_fit;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.fragment;
import static android.R.attr.name;
import static android.R.attr.radioButtonStyle;
import static android.R.attr.trimPathEnd;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class Profile  extends Fragment{
    NumberPicker getAge, getFt, getInch;
    RadioGroup radioGroup;
    RadioButton m,f;
    EditText getName, getWeight;
    Button update;
    ViewPager viewPager;
    String theName;
    private static Profile pro;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);


        return rootView;




    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        update = (Button) getView().findViewById(R.id.button2);
        radioGroup = (RadioGroup) getView().findViewById(R.id.gender);
        m = (RadioButton) getView().findViewById(R.id.male);
        f = (RadioButton) getView().findViewById(R.id.female);
        m.setChecked(true);
        getAge = (NumberPicker) getView().findViewById(R.id.age);
        getFt = (NumberPicker) getView().findViewById(R.id.height_Ft);
        getInch = (NumberPicker) getView().findViewById(R.id.height_Inch);
        getName = (EditText) getView().findViewById(R.id.name);
        getWeight = (EditText) getView().findViewById(R.id.getWeight);
        getFt.setMaxValue(10);
        getFt.setMinValue(1);
        getFt.setValue(6);
        getInch.setMaxValue(12);
        getInch.setMinValue(0);
        getInch.setValue(0);
        getAge.setMinValue(15);
        getAge.setMaxValue(120);
        getAge.setValue(18);
        getFt.setWrapSelectorWheel(false);
        getInch.setWrapSelectorWheel(false);
        getAge.setWrapSelectorWheel(false);
        viewPager = (ViewPager) getActivity().findViewById(R.id.container);
        theName = getName.getText().toString();
        String theWeight = getWeight.getText().toString();
        int selectedIdGender = radioGroup.getCheckedRadioButtonId(); // Getting The Gender
        int theAge = getAge.getValue();
        int theFt = getFt.getValue();
        int theInch = getInch.getValue();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = "";
                if (getName.getText().toString().equals(check) || getWeight.getText().toString().equals(check)) {
                    Toast.makeText(getContext(), "Please fill all the Information",
                            Toast.LENGTH_SHORT).show();
                } else {



                    viewPager.setCurrentItem(3);
                    Toast.makeText(getContext(), "Successfully Updated",
                            Toast.LENGTH_SHORT).show();



//                    Fragment fragment = new Fragment();
//                    Bundle bundle = new Bundle();
//                    info.setArguments(bundle);
//                    bundle.putString("got", theName);
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.add(R.id.container, info, "");
//                    fragment.setArguments(bundle);


                }

            }
        });


    }



}
