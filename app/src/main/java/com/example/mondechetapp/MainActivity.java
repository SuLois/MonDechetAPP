package com.example.mondechetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavBarFragment.OnButtonClickedListener {

    ArrayList<String> rv_data = new ArrayList<>();
    RecyclerView recyclerView;
    RVAdapter rvAdapter;

    void initRVData(){
        rv_data.add("Apple");
        rv_data.add("Banana");
        rv_data.add("Peach");
        rv_data.add("Pineapple");
        rv_data.add("Orange");
        rv_data.add("Strawberry");
        rv_data.add("Grapes");
        rv_data.add("Apricot");
        rv_data.add("Avocado");
        rv_data.add("Raisin");
        rv_data.add("Guava");
        rv_data.add("Papaya");
        rv_data.add("Pear");
        rv_data.add("Blueberry");
        rv_data.add("Lychee");
        rv_data.add("Date");
        rv_data.add("Fig");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavBarFragment navBarFragment = new NavBarFragment();
        SearchFragment searchFragment = new SearchFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.second_placeholder, navBarFragment)
                .add(R.id.first_placeholder, searchFragment)
                .commit();


        //Start RecyclerView
        //prepare list data
        initRVData();

        //create RV adapter from data (fruits strings)
        rvAdapter = new RVAdapter(rv_data);

        recyclerView = (RecyclerView) findViewById(R.id.fragment_main_recycler_view);

        // set adapter to RV
        recyclerView.setAdapter(rvAdapter);

        // set RV layout: vertical list
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // RV size doesn't depend on amount of content
        recyclerView.hasFixedSize();


    }

    @Override
    public void onButtonClicked(int button) {
        Log.e(getClass().getSimpleName(),"Button " + Integer.toString(button) + " clicked !");
        SearchFragment searchFragment = new SearchFragment();
        ScanFragment scanFragment = new ScanFragment();
        AstuceFragment astuceFragment = new AstuceFragment();
        HelpFragment helpFragment = new HelpFragment();

        if(button == 1){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, searchFragment)
                    .commit();
        }

        if(button == 2){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, scanFragment)
                    .commit();
        }

        if(button == 3){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, astuceFragment)
                    .commit();
        }

        if(button == 4){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, helpFragment)
                    .commit();
        }


    }
}
