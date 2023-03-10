package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FemaleActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference watchesRef = db.collection("watches");
    private List<Watch> watches = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);

        watchesRef.whereEqualTo("gender", "Female").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Watch watch = document.toObject(Watch.class);

                        watches.add(watch);
                    }
                    RecyclerView recyclerView = findViewById(R.id.recycler_view_female);
                    recyclerView.setLayoutManager(new LinearLayoutManager(FemaleActivity.this));
                    recyclerView.setAdapter(new WatchesAdapter(watches));
                } else {
                    Log.d("FemaleActivity", "Error getting documents: ", task.getException());
                }
            }
        });




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
            private ImageView image_view;


            public WatchHolder(@NonNull View itemView) {
                super(itemView);
                nameTextView = itemView.findViewById(R.id.text_model);
                brandTextView = itemView.findViewById(R.id.text_brand);
                priceTextView = itemView.findViewById(R.id.text_price);
                image_view = itemView.findViewById(R.id.image_view);

            }

            public void bind(Watch watch) {
                nameTextView.setText(watch.getModel());
                brandTextView.setText(watch.getBrand());
                priceTextView.setText(String.valueOf(watch.getCost()));
                GlideApp.with(itemView.getContext())
                        .load(watch.getMainImageUrl())
                        .into(image_view);
            }
        }
    }
}

