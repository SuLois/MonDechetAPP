package com.example.mondechetapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SearchFragment extends Fragment implements View.OnClickListener{

    private OnButtonClickedListener mCallback;

    public interface OnButtonClickedListener{
        public void onButtonClicked(View view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_search, container, false);
        result.findViewById(R.id.search_button).setOnClickListener(this);

        return result;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        this.createCallbackToParentActivity();
    }

    private void createCallbackToParentActivity() {
        try {
            mCallback = (OnButtonClickedListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }

    @Override
    public void onClick(View v){
        Log.e(getClass().getSimpleName(),"Button clicked !");
    }
}