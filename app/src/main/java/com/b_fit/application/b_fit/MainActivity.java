package com.b_fit.application.b_fit;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

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
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    String Text = "The_Text";
    PopupWindow popupWindow;
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }
        if (id == R.id.app_bar_search)
        {
            try{
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.activity_search, null);
                popupWindow= new PopupWindow(popupView,
                        ViewPager.LayoutParams.WRAP_CONTENT,
                        ViewPager.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(findViewById(R.id.toolbar), Gravity.TOP, 0 ,210);


            }catch (Exception e){}
            return true;
        }

        return super.onOptionsItemSelected(item);
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



}
