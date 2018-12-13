package com.rawggar.exhibit.Activity;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.rawggar.exhibit.Fragment.BagFragment;
import com.rawggar.exhibit.Fragment.DesignFragment;
import com.rawggar.exhibit.Fragment.FavouriteFragment;
import com.rawggar.exhibit.Fragment.HomeFragment;
import com.rawggar.exhibit.Fragment.ProfileFragment;
import com.rawggar.exhibit.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new HomeFragment());

    }

    @Override
    public void onBackPressed() {

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.home_icon:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.design_icon:
                    fragment = new DesignFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.fav_icon:
                    fragment = new FavouriteFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.bag_icon:
                    fragment = new BagFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.profile_icon:
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
