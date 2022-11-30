package com.example.mondechetapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder> {

    //ViewHolder Class in RVAdapter Class
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        //ImageView image;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.rv_item); //rv_item from fragment_search_rv_item
            //image = (ImageView) itemView.findViewById(R.id.image);
        }
    }


    //Start Adapter class
    List<String> dataList;
    public RVAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_search_rv_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.txt.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
