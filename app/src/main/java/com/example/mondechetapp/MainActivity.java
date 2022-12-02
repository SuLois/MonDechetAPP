package com.example.mondechetapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;



import android.app.Activity;
import android.app.assist.AssistStructure;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;


public class MainActivity extends AppCompatActivity implements NavBarFragment.OnButtonClickedListener, ScanFragment.OnButtonClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavBarFragment navBarFragment = new NavBarFragment();
        SearchFragment searchFragment = new SearchFragment();
        ScanOptions options = new ScanOptions();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.second_placeholder, navBarFragment)
                .add(R.id.first_placeholder, searchFragment)
                .commit();

    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                }
            });


    @Override
    public void onButtonClicked(int button) {
        Log.e(getClass().getSimpleName(),"Button " + Integer.toString(button) + " clicked !");
        SearchFragment searchFragment = new SearchFragment();
        ScanFragment scanFragment = new ScanFragment();
        AstuceFragment astuceFragment = new AstuceFragment();
        HelpFragment helpFragment = new HelpFragment();
        DetectionFragment detectionFragment = new DetectionFragment();
        CodeBarreFragment codeBarreFragment = new CodeBarreFragment();


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
        if(button == 5){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, codeBarreFragment)
                    .commit();
            barcodeLauncher.launch(new ScanOptions());
        }
        if(button == 6){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, detectionFragment)
                    .commit();
        }

    }
}
