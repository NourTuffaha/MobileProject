package com.example.mobileproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.core.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Shamsaldeen Tuffaha Shop - Watches
Nour Tuffaha - 1192106

Tala Dabbagh - 1200620

Sojood Mafarjeh - 1181205

Nour: Home activity, All watches activity, Object Parcel, SQLite (beta)

Tala: Cart activity, Wishlist activity, navigation bar (beta)

Sojood: Watch details activity, payment activity

*Each group member's contribution is not limited to mentioned input.

*Current project state is primitive and not even in the beta scheme of things; The project roadmap
was surprisingly demanding and we were limited by our unoptimized timeline.

*Next phase, the project will have a functioning database, navigation bar, every possible function
required by a shop, and more.

 */
public class MainActivity extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference watchesRef = db.collection("watches");
    private List<Watch> watches = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Data.fillWatches();

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////

        watchesRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Watch watch = document.toObject(Watch.class);
                        watches.add(watch);
                    }
                    Intent intent = new Intent(MainActivity.this, WatchesActivity.class);
                    intent.putParcelableArrayListExtra("watches", (ArrayList<Watch>) watches);
                    startActivity(intent);
                } else {
                    Log.d("MainActivity", "Error getting documents: ", task.getException());
                }
            }
        });

        Button menBtn = findViewById(R.id.menBtn);
            Button womenBtn = findViewById(R.id.womenBtn);



        }
    }
