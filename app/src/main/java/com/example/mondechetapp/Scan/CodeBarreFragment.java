package com.example.mondechetapp.Scan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mondechetapp.MainActivity;
import com.example.mondechetapp.R;

public class CodeBarreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_code_barre, container, false);
        return result;
    }

    public void changeText(String newCB, String newName, String newBac) {
        TextView textviewCB = (TextView) getView().findViewById(R.id.textCB);
        textviewCB.setText(newCB);
        TextView textviewName = (TextView) getView().findViewById(R.id.textName);
        textviewName.setText(newName);
        TextView textviewBac = (TextView) getView().findViewById(R.id.textBac);
        textviewBac.setText(newBac);

        String Recyclage = "Recyclage";
        String Verre = "Verre";
        String DechetMetal = "Déchetterie métal";
        String Ordure = "Ordure ménagère";
        ImageView imageView = (ImageView) getView().findViewById(R.id.imageView);
        if(newBac.equals(Recyclage)){
            imageView.setImageResource(R.drawable.poubelle__jaune);
        }
        if(newBac.equals(Verre)){
            imageView.setImageResource(R.drawable.verre);
        }
        if(newBac.equals(DechetMetal)){
            imageView.setImageResource(R.drawable.metal);
        }
        if(newBac.equals(Ordure)){
            imageView.setImageResource(R.drawable.poubelle__jaune);
        }
    }
}