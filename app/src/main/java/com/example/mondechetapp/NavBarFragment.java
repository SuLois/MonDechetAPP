package com.example.mondechetapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavBarFragment extends Fragment implements View.OnClickListener{

    private OnButtonClickedListener callback;

    public interface OnButtonClickedListener{
        public void onButtonClicked(int button);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_navbar, container, false);
        result.findViewById(R.id.search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 1;
                callback.onButtonClicked(position);
            }
        });
        result.findViewById(R.id.scan_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 2;
                callback.onButtonClicked(position);
            }
        });
        result.findViewById(R.id.astuce_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 3;
                callback.onButtonClicked(position);
            }
        });
        result.findViewById(R.id.help_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = 4;
                callback.onButtonClicked(position);
            }
        });

        return result;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        this.createCallbackToParentActivity();
    }

    private void createCallbackToParentActivity() {
        try {
            callback = (OnButtonClickedListener) getActivity();
             }catch (ClassCastException e){
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }

    @Override
    public void onClick(View v){
        Log.e(getClass().getSimpleName(),"Button clicked !");
    }
}