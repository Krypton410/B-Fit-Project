package com.b_fit.application.b_fit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Maxwell on 7/1/2017.
 */

public class Login extends AppCompatActivity{
    NumberPicker getAge, getFt, getInch;
    RadioGroup radioGroup;
    RadioButton m,f;
    EditText getName, getWeight;
    Button update;
    Spinner weightUnit;
    CustomSwipeAdapter adapter;
    ViewPager viewPager;
    String theName, theWeight, theGender;
    int theAge,theFt,theInch;
    SharedPreferences pref, pref2;
    SharedPreferences.Editor editor;
    //For Shared Preferences
    String spName, spGender, spWeight;
    int spAge, spFt, spInch;
    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_profile);




    update = (Button) findViewById(R.id.button2);
    radioGroup = (RadioGroup) findViewById(R.id.gender);
    m = (RadioButton) findViewById(R.id.male);
    f = (RadioButton) findViewById(R.id.female);
    m.setChecked(true);
    getAge = (NumberPicker) findViewById(R.id.age);
    getFt = (NumberPicker) findViewById(R.id.height_Ft);
    getInch = (NumberPicker) findViewById(R.id.height_Inch);
    getName = (EditText) findViewById(R.id.name);
    getWeight = (EditText) findViewById(R.id.getWeight);
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

        viewPager = (ViewPager) findViewById(R.id.ViewPager1);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);




            update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String check = "";



                if (getName.getText().toString().equals(check) || getWeight.getText().toString().equals(check)) {
                    Toast.makeText(Login.this, "Please fill all the Information",
                            Toast.LENGTH_SHORT).show();


                } else if (!getName.getText().toString().equals(check) || !getWeight.getText().toString().equals(check)) {
                    pref = getSharedPreferences("user_Info", MODE_PRIVATE);
                    editor = pref.edit();
                    weightUnit = (Spinner) findViewById(R.id.unitWeight);
                    theName = getName.getText().toString();
                    theWeight = getWeight.getText().toString();
                    int selectedIdGender = radioGroup.getCheckedRadioButtonId();// Getting The Gender
                    theGender = ((RadioButton) findViewById(selectedIdGender)).getText().toString();
                    theAge = getAge.getValue();
                    theFt = getFt.getValue();
                    theInch = getInch.getValue();

                    if (weightUnit.getSelectedItem().equals("Lbs")) {
                        //Converts Lbs to kg if Lbs
                        theWeight = String.valueOf(Double.parseDouble(theWeight) * 0.45);
                    }

                    //Saving the data's


                    //edit data
                    editor = pref.edit();
                    editor.putString("name", theName);
                    editor.putString("gender", theGender);
                    editor.putInt("age", theAge);
                    editor.putInt("ft", theFt);
                    editor.putInt("inch", theInch);
                    editor.putString("weight", theWeight);
                    editor.apply();


                    //Shared Preferences for getting info
                    pref2 = getSharedPreferences("user_Info", Context.MODE_PRIVATE);
                    spName = pref2.getString("name", "");
                    spGender = pref2.getString("gender", "");
                    spWeight = pref2.getString("weight", "");
                    spAge = pref2.getInt("age", 0);
                    spFt = pref2.getInt("ft", 0);
                    spInch = pref2.getInt("inch", 0);

                    DataHolder.setName(spName);
                    DataHolder.setGender(spGender);
                    DataHolder.setAge(spAge);
                    DataHolder.setWeight(spWeight);
                    DataHolder.setFeet(spFt);
                    DataHolder.setInch(spInch);

                }


            pref2 = getSharedPreferences("user_Info", Context.MODE_PRIVATE);
            spName = pref2.getString("name", "");
            spGender = pref2.getString("gender", "");
            spWeight = pref2.getString("weight", "");
            spAge = pref2.getInt("age", 0);
            spFt = pref2.getInt("ft", 0);
            spInch = pref2.getInt("inch", 0);


                DataHolder.setName(spName);
                DataHolder.setGender(spGender);
                DataHolder.setAge(spAge);
                DataHolder.setWeight(spWeight);
                DataHolder.setFeet(spFt);
                DataHolder.setInch(spInch);
            Intent i = new Intent(Login.this, splash_Screen.class);
            startActivity(i);

                if (getName.getText().toString().equals(check) || getWeight.getText().toString().equals(check)) {
                    Toast.makeText(Login.this, "Update Failed",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Successfully Updated",
                            Toast.LENGTH_SHORT).show();
                }

            }


    });


}






//    public void save(View v){
//        SharedPreferences pref = getSharedPreferences("user_Info" ,MODE_PRIVATE);
//        //edit data
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("name", theName);
//        editor.putString("gender",theGender);
//        editor.putInt("age",theAge);
//        editor.putInt("ft", theFt);
//        editor.putInt("inch", theInch);
//        editor.putString("weight", theWeight);
//        editor.putBoolean("State", true); //added state
//        editor.apply();
//    }
//
//    public void getSaved(View v){
//        SharedPreferences pref = getSharedPreferences("user_Info", Context.MODE_PRIVATE);
//        String spName = pref.getString("name", "");
//        String spGender = pref.getString("gender", "");
//        String spWeight = pref.getString("weight", "");
//        int spAge = pref.getInt("age", 0);
//        int spFt = pref.getInt("ft", 0);
//        int spInch = pref.getInt("inch", 0);
//
//        DataHolder.setName(spName);
//        DataHolder.setGender(spGender);
//        DataHolder.setAge(spAge);
//        DataHolder.setWeight(spWeight);
//        DataHolder.setFeet(spFt);
//        DataHolder.setInch(spInch);
//
//    }
//
//    public boolean isLoggedIn(){
//        return pref.getBoolean("State", false);
//    }
//    public void setIsLoggedIn(boolean state){
//        editor = pref.edit();
//        editor.putBoolean("State", state);
//        editor.commit();
//
//    }
}

