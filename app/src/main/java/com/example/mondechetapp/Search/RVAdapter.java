package com.example.mondechetapp.Search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mondechetapp.R;

import java.util.Random;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RecyclerViewHolder> implements OnItemListener {

    private final OnItemListener onItemListener;
    private Random random;

    public RVAdapter(int seed,
                     OnItemListener onItemListener) {
        this.random = new Random(seed);
        this.onItemListener = onItemListener;
    }

    @Override
    public void onItemClick(int position) {

    }


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
        holder.getView().setText(String.valueOf(random.nextInt()));
    }

    @Override
    public int getItemCount() {
        return 100;
    }



    //ViewHolder Class in RVAdapter Class and OnItemListener interface in ViewHolder Class
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView view;
        //ImageView image;

        public RecyclerViewHolder(View itemView, OnItemListener onItemListener) {
            super(itemView);
            view = itemView.findViewById(R.id.randomText); //rv_item from fragment_search_rv_item

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemListener != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            onItemListener.onItemClick(pos);
                        }

                    }
                }
            });
            //image = (ImageView) itemView.findViewById(R.id.image);
        }
        public TextView getView(){
            return view;
        }

    }


}