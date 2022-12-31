package com.example.mondechetapp;

import static com.google.common.base.Ascii.FF;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//Ce fichier permet de gérer le fragment NavBar
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
        //Récupération de la position du bouton cliqué
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

    //Liaison avec la MainActivity
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

    //Message en log
    @Override
    public void onClick(View v){
        Log.e(getClass().getSimpleName(),"Button clicked !");
    }
}