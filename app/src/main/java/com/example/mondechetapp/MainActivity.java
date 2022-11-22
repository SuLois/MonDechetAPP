package com.example.mondechetapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity implements NavBarFragment.OnButtonClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavBarFragment navBarFragment = new NavBarFragment();
        SearchFragment searchFragment = new SearchFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.navbar, navBarFragment)
                .add(R.id.search, searchFragment)
                .commit();

    }

    @Override
    public void onButtonClicked(View view) {
        Log.e(getClass().getSimpleName(),"Button clicked !");
    }
}
