package com.example.mondechetapp.Scan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mondechetapp.R;
import com.google.zxing.client.android.Intents;

public class ScanFragment extends Fragment implements View.OnClickListener {

    private OnButtonClickedListener callback;

    public interface OnButtonClickedListener{
        public void onButtonClicked(int button);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_scan, container, false);

        result.findViewById(R.id.buttonCodeBarre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 5;
                callback.onButtonClicked(position);
            }
        });
        result.findViewById(R.id.buttonDetection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 6;
                callback.onButtonClicked(position);
            }

        });
        return result;
    }

    @Override public void onAttach(Context context){
        super.onAttach(context);

        this.createCallbackToParentActivity();
    }

    private void createCallbackToParentActivity(){
            try {
                callback = (OnButtonClickedListener) getActivity();
            }catch (ClassCastException e){
                throw new ClassCastException(e.toString()+ "must implement OnButtonClickedListener");
        }
    }

    @Override
    public void onClick(View view) {
        Log.e(getClass().getSimpleName(),"Button clicked !");
    }

}