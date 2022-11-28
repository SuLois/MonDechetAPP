package com.example.mondechetapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ScanFragment extends Fragment implements View.OnClickListener {

    private NavBarFragment.OnButtonClickedListener callback;

    @Override
    public void onClick(View view) {
        Log.e(getClass().getSimpleName(),"Button clicked !");
    }

    public interface OnButtonClickedListener{
        public void onButtonClicked(int button);
    }

    public ScanFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_scan, container, false);
        result.findViewById(R.id.buttonCodeBarre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 1;
                callback.onButtonClicked(position);
            }
        });
        result.findViewById(R.id.buttonDetection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 2;
                callback.onButtonClicked(position);
            }

        });
        return result;
    }
}