
package com.rawggar.exhibit.Fragment;


import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.rawggar.exhibit.Adapter.ShirtAdapter;
import com.rawggar.exhibit.R;
import com.rawggar.exhibit.model.category;
import com.rawggar.exhibit.Adapter.CategoryAdapter;
import com.rawggar.exhibit.model.tShirt;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private static final String URL = "https://api.androidhive.info/json/movies_2017.json";

    private RecyclerView categoryRecyclerView;
    private List<category> categoryList;
    private CategoryAdapter mCategoryAdapter;

    private RecyclerView shirtRecyclerView;
    private List<tShirt> shirtList;
    private ShirtAdapter mShirtAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recycler_view);
        categoryList = new ArrayList<>();
        mCategoryAdapter = new CategoryAdapter(getActivity(), categoryList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(mLayoutManager);
        categoryRecyclerView.setAdapter(mCategoryAdapter);

        fetchCategoryItems();

        shirtRecyclerView = view.findViewById(R.id.shirt_recylcer_view);
        shirtList = new ArrayList<>();
        mShirtAdapter = new ShirtAdapter(getActivity(), shirtList);

        RecyclerView.LayoutManager mLayoutManagerShirt = new GridLayoutManager(getActivity(), 2);
        shirtRecyclerView.setLayoutManager(mLayoutManagerShirt);
        shirtRecyclerView.setAdapter(mShirtAdapter);

        fetchShirtItems();



        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void fetchCategoryItems() {
                        categoryList.clear();
                        List<category>items = new ArrayList<>();

                        items.add(new category("Trending",1));
                        items.add(new category("Top",2));
                        items.add(new category("Latest",3));
                        items.add(new category("Sale",4));
                        items.add(new category("Sports",5));

                        categoryList.addAll(items);
                        // refreshing recycler view
                        mCategoryAdapter.notifyDataSetChanged();
    }

    private void fetchShirtItems() {
        shirtList.clear();
        List<tShirt>items = new ArrayList<>();

        items.add(new tShirt("https://images.sportsdirect.com/images/products/59839518_l.jpg","Superboy"));
        items.add(new tShirt("https://images.bewakoof.com/original/dabbing-panda-half-sleeve-t-shirt-men-s-printed-t-shirts-1514635235.jpg","Dark Ninja"));
        items.add(new tShirt("https://www.dhresource.com/0x0s/f2-albu-g4-M00-04-47-rBVaEVmbydCAYuH_AAFEgKYJNhs136.jpg/blown-unique-tee-shirts-hombre-hot-selling.jpg","Pink Safari"));
        items.add(new tShirt("https://images.sportsdirect.com/images/products/59839518_l.jpg","SuperMan"));
        items.add(new tShirt("https://images.bewakoof.com/original/dabbing-panda-half-sleeve-t-shirt-men-s-printed-t-shirts-1514635235.jpg","Zimba"));
        items.add(new tShirt("https://www.dhresource.com/0x0s/f2-albu-g4-M00-04-47-rBVaEVmbydCAYuH_AAFEgKYJNhs136.jpg/blown-unique-tee-shirts-hombre-hot-selling.jpg","Gunman"));
        items.add(new tShirt("https://images.sportsdirect.com/images/products/59839518_l.jpg","Coolguy"));
        items.add(new tShirt("https://images.bewakoof.com/original/dabbing-panda-half-sleeve-t-shirt-men-s-printed-t-shirts-1514635235.jpg","Stud"));
        items.add(new tShirt("https://www.dhresource.com/0x0s/f2-albu-g4-M00-04-47-rBVaEVmbydCAYuH_AAFEgKYJNhs136.jpg/blown-unique-tee-shirts-hombre-hot-selling.jpg","My child"));
        items.add(new tShirt("https://images.sportsdirect.com/images/products/59839518_l.jpg","Wierdo"));
        items.add(new tShirt("https://images.bewakoof.com/original/dabbing-panda-half-sleeve-t-shirt-men-s-printed-t-shirts-1514635235.jpg","Jaat"));
        items.add(new tShirt("https://www.dhresource.com/0x0s/f2-albu-g4-M00-04-47-rBVaEVmbydCAYuH_AAFEgKYJNhs136.jpg/blown-unique-tee-shirts-hombre-hot-selling.jpg","Cradzy"));
        shirtList.addAll(items);
        // refreshing recycler view
        mShirtAdapter.notifyDataSetChanged();
    }

}
