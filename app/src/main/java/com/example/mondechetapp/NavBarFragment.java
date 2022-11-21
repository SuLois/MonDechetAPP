package com.example.mondechetapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NavBarFragment extends Fragment implements View.OnClickListener{

    private OnButtonClickedListener searchCallback;
    private OnButtonClickedListener scanCallback;
    private OnButtonClickedListener astuceCallback;
    private OnButtonClickedListener helpCallback;

    public interface OnButtonClickedListener{
        public void onButtonClicked(View view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_navbar, container, false);
        result.findViewById(R.id.search_button).setOnClickListener(this);
        result.findViewById(R.id.scan_button).setOnClickListener(this);
        result.findViewById(R.id.astuce_button).setOnClickListener(this);
        result.findViewById(R.id.help_button).setOnClickListener(this);

        return result;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        this.createCallbackToParentActivity();
    }

    private void createCallbackToParentActivity() {
        try {
            searchCallback = (OnButtonClickedListener) getActivity();
            scanCallback = (OnButtonClickedListener) getActivity();
            astuceCallback = (OnButtonClickedListener) getActivity();
            helpCallback = (OnButtonClickedListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }

    @Override
    public void onClick(View v){
        Log.e(getClass().getSimpleName(),"Button clicked !");
    }
}