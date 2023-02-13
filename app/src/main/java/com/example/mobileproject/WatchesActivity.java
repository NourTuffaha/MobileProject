package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WatchesActivity extends AppCompatActivity {
    private List<Watch> watches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watches);

        Intent intent = getIntent();
        if (intent.hasExtra("watches")) {
            watches = intent.getParcelableArrayListExtra("watches");
        }
        // Show the watches in a RecyclerView or any other method you prefer.
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new WatchesAdapter(watches));

    }

    private class WatchesAdapter extends RecyclerView.Adapter<WatchesAdapter.WatchHolder> {
        private List<Watch> watches;

        public WatchesAdapter(List<Watch> watches) {
            this.watches = watches;
        }

        @NonNull
        @Override
        public WatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_watch, parent, false);
            return new WatchHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull WatchHolder holder, int position) {
            Watch watch = watches.get(position);
            holder.bind(watch);
        }

        @Override
        public int getItemCount() {
            return watches.size();
        }

        class WatchHolder extends RecyclerView.ViewHolder {
            private TextView nameTextView;
            private TextView brandTextView;
            private TextView priceTextView;

            public WatchHolder(@NonNull View itemView) {
                super(itemView);
                nameTextView = itemView.findViewById(R.id.text_model);
                brandTextView = itemView.findViewById(R.id.text_brand);
                priceTextView = itemView.findViewById(R.id.text_price);
            }

            public void bind(Watch watch) {
                nameTextView.setText(watch.getModel());
                brandTextView.setText(watch.getBrand());
                priceTextView.setText(String.valueOf(watch.getCost()));
            }
        }
    }
    }

