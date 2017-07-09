package com.b_fit.application.b_fit;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.MessageQueue;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity{

    /*
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    EditText search;
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    String Text = "The_Text";
    TextView one, two, three, four, five, six, seven, eight, nine, ten;
    PopupWindow popupWindow;
    String theSearch;
    int searchIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //viewPager = (ViewPager) findViewById(R.id.ViewPager1);
        adapter = new CustomSwipeAdapter(this);
        //viewPager.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_directions_run_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_restaurant_menu_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_data_usage_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_info_white_24dp);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            //noinspection SimplifiableIfStatement
            case R.id.help:

                Intent i = new Intent(this, Help.class);
                this.startActivity(i);
                break;


            case R.id.connect:
                Intent intent = new Intent(this, Connect.class);
                this.startActivity(intent);
                break;


            case R.id.app_bar_search:

                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//                View popupView = layoutInflater.inflate(R.layout.activity_search, null);

                final LinearLayout popupView = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_search, null);

                popupWindow = new PopupWindow(popupView,
                        ViewPager.LayoutParams.WRAP_CONTENT,
                        ViewPager.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(findViewById(R.id.toolbar), Gravity.TOP, 0, 208);
                popupWindow.setFocusable(true);
                popupWindow.update();




                    one = (TextView) popupView.findViewById(R.id.one);
                    two = (TextView) popupView.findViewById(R.id.two);
                    three = (TextView) popupView.findViewById(R.id.three);
                    four = (TextView) popupView.findViewById(R.id.four);
                    five = (TextView) popupView.findViewById(R.id.five);
                    six = (TextView) popupView.findViewById(R.id.six);
                    seven = (TextView) popupView.findViewById(R.id.seven);
                    eight = (TextView) popupView.findViewById(R.id.eight);
                    nine = (TextView) popupView.findViewById(R.id.nine);
                    ten = (TextView) popupView.findViewById(R.id.ten);
                    search = (EditText) popupView.getRootView().findViewById(R.id.activitySearch);

                ArrayList<TextView> searchable = new ArrayList<>(Arrays.asList(

                        one,two,three,four,five,six,seven,eight,nine,ten
                ));

                TextView[] test1 = new TextView[10];
                test1[0] = one;
                test1[1] = two;
                test1[2] = three;
                test1[3] = four;
                test1[4] = five;
                test1[5] = six;
                test1[6] = seven;
                test1[7] = eight;
                test1[8] = nine;
                test1[9] = ten;


                Arrays.sort(DataHolder.getExercise());

                search.setText("", TextView.BufferType.SPANNABLE);
                ArrayList<String> converted = new ArrayList<>(Arrays.asList(DataHolder.getExercise()));

           for (int x = 0; x < converted.size(); x++){
                try{
               searchable.get(x).setText(converted.get(x));
                 test1[x].setText(converted.get(x));
                }catch (Exception e){Toast.makeText(this, "Unavailable", Toast.LENGTH_SHORT).show();}
           }


//            ten.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Toast.makeText(this, "You Cliced the Button!", Toast.LENGTH_SHORT).show();
//                }
//            });




                    search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                            if(actionId == EditorInfo.IME_ACTION_SEARCH){

                                theSearch = search.getText().toString().toLowerCase();
                                try{searchIndex = binarySearch(DataHolder.getExercise(), theSearch);}
                                catch(Exception e){ one.setText("Retry"); }
                                return true;
                            }

                            return false;
                        }
                    });


            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }




    //PlaceHolderFragment Deleted

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        Generator gen = new Generator();
        Info inf = new Info();




        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
//             Return a PlaceholderFragment (defined as a static inner class below).


            switch (position) {

                case 0:
                    return gen;
                case 1:
                    Calculator cal = new Calculator();
                    return cal;
                case 2:
                    Graph graph = new Graph();
                    return graph;
                case 3:
                    return inf;
            }
            return null;


        }



        @Override
        public int getCount() {
            // Show 3 total pages.
//            viewPager.setCurrentItem(1);
            return 4;

        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
//                case 0:
//                    Profile profile = new Profile();
//                    return "Profile";
                case 0:
                    return "GENERATOR";
                case 1:
                    return "NUTRITION";
                case 2:
                    return  "Statistics";
                case 3:
                    return "Info";
            }
            return null;


        }






    }
    public int binarySearch(String[] a, String y) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        String[] x = a;
        y.replaceAll(" ", "");
        for(int i = 0; i < a.length; i++){
            a[i] = a[i].toLowerCase();
            a[i] = a[i].replaceAll(" ", "");
            x = a;
        }


        while (low <= high) {
            mid = (low + high) / 2;

            if (x[mid].compareTo(y) < 0) {
                low = mid + 1;
            } else if (x[mid].compareTo(y) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }


        for(int i = 0; i < a.length; i++){
            DataHolder.getExercise()[i] = a[i].toUpperCase();
            DataHolder.getExercise()[i] = a[i];

        }

        Toast.makeText(this, searchIndex != -1 ? DataHolder.getExercise()[searchIndex]+ " - Index is "+searchIndex : "Not found", Toast.LENGTH_LONG).show();
        return -1;
    }

        //yourString.replaceAll(" ","");


}
