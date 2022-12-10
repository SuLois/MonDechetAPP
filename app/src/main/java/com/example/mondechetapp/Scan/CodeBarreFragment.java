package com.example.mondechetapp.Scan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mondechetapp.R;

public class CodeBarreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView textView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CodeBarreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CodeBarreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CodeBarreFragment newInstance(String param1, String param2) {
        CodeBarreFragment fragment = new CodeBarreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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
    }
}