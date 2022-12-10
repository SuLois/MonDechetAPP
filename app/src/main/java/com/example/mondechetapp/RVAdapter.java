package com.example.mondechetapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RecyclerViewHolder> {

    //ViewHolder Class in RVAdapter Class
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView view;
        //ImageView image;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.randomText); //rv_item from fragment_search_rv_item
            //image = (ImageView) itemView.findViewById(R.id.image);
        }
        public TextView getView(){
            return view;
        }
    }


    private Random random;

    public RVAdapter(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.fragment_search_rv_item;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getView().setText(String.valueOf(random.nextInt()));
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}