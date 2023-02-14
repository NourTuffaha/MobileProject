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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Data.fillWatches();

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////


        Button allBtn = findViewById(R.id.allBtn);
        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WatchesActivity.class);
                startActivity(intent);
            }
        });
        Button menBtn = findViewById(R.id.menBtn);

        menBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WatchesActivity.class);
                startActivity(intent);
            }
        });
        Button womenBtn = findViewById(R.id.womenBtn);
        womenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WatchesActivity.class);
                startActivity(intent);
            }
        });
        Button bagbtn = findViewById(R.id.bagBtn);
        bagbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        Button wishlistbtn = findViewById(R.id.wishlistBtn);

        wishlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WishlistActivity.class);
                startActivity(intent);
            }
        });
    }


    public void btnHomeOnClick(View view) {
    }

    public void btnWatchOClick(View view) {
        Intent sendingIntent = new Intent(this, WatchesActivity.class);
        startActivity(sendingIntent);
    }

    public void btnShopOnClick(View view) {
        Intent sendingIntent = new Intent(this, CartActivity.class);
        startActivity(sendingIntent);
    }
}
