package com.example.mondechetapp.Search;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mondechetapp.MainActivity;
import com.example.mondechetapp.R;
import com.example.mondechetapp.Scan.CodeBarreFragment;


public class SearchFragment extends Fragment implements OnItemListener {

    // Add RecyclerView member
    private RecyclerView recyclerView;
    CodeBarreFragment codeBarreFragment = new CodeBarreFragment();


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new RVAdapter(1234, this));

        return view;
    }


    @Override
    public void onItemClick(int position) {
        ((MainActivity) getActivity()).replaceFragments();
    }
}