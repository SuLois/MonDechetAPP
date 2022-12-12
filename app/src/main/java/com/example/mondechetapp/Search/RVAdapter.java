package com.example.mondechetapp.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mondechetapp.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RecyclerViewHolder> implements OnItemListener {

    private final OnItemListener onItemListener;
    ArrayList<RVItem> rvItemArrayList;
    String itemName;
    private OnItemListener listener;
    FirebaseFirestore db;
    String name;



    public RVAdapter(ArrayList<RVItem> rvItemArrayList,
                     OnItemListener onItemListener) {
        this.rvItemArrayList = rvItemArrayList;
        this.onItemListener = onItemListener;
    }

    @Override
    public void onItemClick(int position) {}
    @Override
    public void onItemRetrieve(DocumentSnapshot documentSnapshot, int position) {}


    @Override
    public int getItemViewType(final int position) {
        return R.layout.fragment_search_rv_item;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        RVItem item = rvItemArrayList.get(position);
        itemName = item.name;
        holder.getView().setText(item.name);
    }

    public String getItemName() {
        return itemName;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getItemCount() {
        return rvItemArrayList.size();
    }



    //ViewHolder Class in RVAdapter Class and OnItemListener interface in ViewHolder Class
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView view;
        //ImageView image;

        public RecyclerViewHolder(View itemView, OnItemListener onItemListener) {
            super(itemView);
            view = itemView.findViewById(R.id.itemText); //rv_item from fragment_search_rv_item

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemListener != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            onItemListener.onItemClick(pos);
                        }
                    }
                    /*int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null){
                        listener.onItemRetrieve(getSnapshots().getSnapshot(position), position);
                    }*/
                }
            });
            //image = (ImageView) itemView.findViewById(R.id.image);
        }
        public TextView getView(){
            return view;
        }
    }
    public void SetOnItemListener(OnItemListener listener){
        this.listener = listener;
    }

}