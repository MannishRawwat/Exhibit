package com.rawggar.exhibit.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.rawggar.exhibit.Fragment.BagFragment;
import com.rawggar.exhibit.Fragment.DesignFragment;
import com.rawggar.exhibit.Fragment.FavouriteFragment;
import com.rawggar.exhibit.Fragment.HomeFragment;
import com.rawggar.exhibit.Fragment.ProfileFragment;
import com.rawggar.exhibit.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MaterialSearchView searchView;
    private BottomNavigationView navigation;
    private NestedScrollView nestedScrollView;
    private LinearLayout linearLayout;

    private ListView lstView;
    String[] lstSource = {
            "Harry",
            "Ron",
            "Major",
            "Huyata",
            "makaha",
            "chalan",
            "last"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        linearLayout = (LinearLayout) findViewById(R.id.search_results);
        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        lstView = (ListView)findViewById(R.id.lstview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.suggestion_row,lstSource);
        lstView.setAdapter(adapter);

        searchView = findViewById(R.id.material_search_bar);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText!=null && !newText.isEmpty()){
                    List<String>lsFound = new ArrayList<>();
                    for(String item:lstSource){
                        if(item.contains(newText)){
                            lsFound.add(item);

                        }
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.suggestion_row,lsFound);
                    lstView.setAdapter(adapter);
                }

                return true;
            }
        });

        Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle("EXHIBIT");
        }
        toolbar.setTitleTextColor(Color.parseColor("#000000"));



        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //show list
                Log.d("focuss","shown");

                linearLayout.setVisibility(View.VISIBLE);
                nestedScrollView.setVisibility(View.GONE);
                navigation.setVisibility(View.GONE);

            }

            @Override
            public void onSearchViewClosed() {
                //do not show it
                Log.d("focuss","hidden");
                linearLayout.setVisibility(View.GONE);


                nestedScrollView.setVisibility(View.VISIBLE);
                navigation.setVisibility(View.VISIBLE);


            }
        });


        loadFragment(new HomeFragment());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem item = menu.findItem(R.id.search_item);
        searchView.setMenuItem(item);
        return true;
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
