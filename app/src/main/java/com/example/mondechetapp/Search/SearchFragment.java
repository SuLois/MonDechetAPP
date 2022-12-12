package com.example.mondechetapp.Search;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mondechetapp.BDD.Dechet;
import com.example.mondechetapp.MainActivity;
import com.example.mondechetapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class SearchFragment extends Fragment implements OnItemListener {

    // Add RecyclerView member
    private RecyclerView recyclerView;
    ArrayList<RVItem> rvItemArrayList;
    RVAdapter rvAdapter;
    FirebaseFirestore db;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        db = FirebaseFirestore.getInstance();
        rvItemArrayList = new ArrayList<RVItem>();
        rvAdapter = new RVAdapter(rvItemArrayList, SearchFragment.this);

        EventChangeListener();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(rvAdapter);

        return view;
    }

    private void EventChangeListener() {
        db.collection("Listes_Dechets").orderBy("name", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }

                        for (DocumentChange dc : value.getDocumentChanges()){
                            if (dc.getType() == DocumentChange.Type.ADDED){
                                rvItemArrayList.add(dc.getDocument().toObject(RVItem.class));
                            }
                            rvAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }


    MainActivity mainActivity;
    //mainActivity = new MainActivity(db) {}


    @Override
    public void onItemClick(int position) {
        ((MainActivity) getActivity()).replaceFragments();

        String itemName = rvAdapter.getItemName();

        ((MainActivity) getActivity()).findFromName(itemName);
        //Toast.makeText(getActivity(), itemName, Toast.LENGTH_LONG).show();
    }


}