package com.example.mobileproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class WatchAdapter extends RecyclerView.Adapter<WatchAdapter.WatchViewHolder> {
    private List<Watch> watches;

    public WatchAdapter(List<Watch> watches) {
        this.watches = watches;
    }

    @NonNull
    @Override
    public WatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_watch, parent, false);
        return new WatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchViewHolder holder, int position) {
        Watch watch = watches.get(position);
        holder.textModel.setText(watch.getModel());
        holder.textBrand.setText(watch.getBrand());
        holder.textPrice.setText(String.valueOf(watch.getCost()));

        // Load the image using Glide library
        GlideApp.with(holder.itemView.getContext())
                .load(watch.getMainImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return watches.size();
    }

    class WatchViewHolder extends RecyclerView.ViewHolder {
        TextView textModel;
        TextView textBrand;
        TextView textPrice;
        ImageView imageView;

        public WatchViewHolder(@NonNull View itemView) {
            super(itemView);
            textModel = itemView.findViewById(R.id.text_model);
            textBrand = itemView.findViewById(R.id.text_brand);
            textPrice = itemView.findViewById(R.id.text_price);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
