package com.example.mobileproject;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Data {
public static void fillWatches() {

    List<Watch> watches = new ArrayList<>();

    watches.add(new Watch("GSTB400_1A", "Casio", "G-Shock", "Male",
            320.00, "200M Water Resistant", "Bluetooth Connectivity", "Tough Solar Power", 5, 0, "gs://shop-4ee63.appspot.com/Watches/Main/GSTB400_Main.png"));
    watches.add(new Watch("GA2100_7A", "Casio", "G-Shock", "Male",
            99.00, "Super LED Light", "200M Water Resistant", "Shock Resistant", 5, 0, "gs://shop-4ee63.appspot.com/Watches/Main/GA2100_7A.png"));
    watches.add(new Watch("GA700_4A", "Casio", "G-Shock", "Male",
            99.00, "200M Water Resistant", "Shock Resistant", "Front-Button Super Illuminator Light", 5, 0, "gs://shop-4ee63.appspot.com/Watches/Main/GA700_4A.png"));
    watches.add(new Watch("GA2200M_1A", "Casio", "G-Shock", "Male",
            130.00, "Carbon Core Guard Case", "200M Water Resistant", "Shock Resistant", 5, 0, "gs://shop-4ee63.appspot.com/Watches/Main/GA2200M-1A_large.png"));
    watches.add(new Watch("GMAS120MF_202", "Casio", "G-Shock", "Male",
            130.00, "Magnetic Resistant", "", "200M Water Resistant", 5, 0, "gs://shop-4ee63.appspot.com/Watches/Main/GMAS120MF_202.png"));
    watches.add(new Watch("GSTB300SD_1A", "Casio", "G-Shock", "Male",
            400.00, "200M Water Resistant", "Tough Solar Power", "Bluetooth smartphone link", 5, 0, "gs://shop-4ee63.appspot.com/Watches/Main/GSTB300SD_1A_Main.png"));
        watches.add(new Watch("GBA900RD_4A", "Casio", "G-Shock", "Male",
                130.00, "200M Water Resistant", "Shock Resistant", "Step Tracker", 5, 0, "gs://shop-4ee63.appspot.com/Watches/Main/GBA900RD_4A_Main.png"));
        watches.add(new Watch("GSTB100GC_1A", "Casio", "G-Shock", "Male",
                420.00, "200M Water Resistant", "Bluetooth Connectivity", "Tough Solar Power", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/GSTB100GC_1A_Main.png"));
        watches.add(new Watch("GA700VB_1A", "Casio", "G-Shock", "Male",
                110.00, "Water Resistant", "Shock Resistant", "Stopwatch", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/GA700VB_1A_Main.png"));
        watches.add(new Watch("GSTS100G_1B", "Casio", "G-Shock", "Male",
                300.00, "Layer Guard Structure", "Tough Solar Power", "Forged Parts", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/GSTS100G_1B_Main.png"));
        watches.add(new Watch("EFR571AT_1A", "Casio", "Edifice", "Male",
                250.00, "100M Water Resistant", "1 Second Stopwatch", " ", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/EFR571AT_1A_Main.png"));
        watches.add(new Watch("EQB1000D_1A", "Casio", "Edifice", "Male",
                330.00, "Solar Powered", "Stopwatch", "Mobile Link Function", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/EQB1000D_1A_Main.png"));
        watches.add(new Watch("EFV590D_2AV", "Casio", "Edifice", "Male",
                99.00, "100M Water Resistant", "Stopwatch", " ", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/EFV590D_2AV_Main.png"));
        watches.add(new Watch("ECB900DB_1A", "Casio", "Edifice", "Male",
                220.00, "Solar Powered", "Bluetooth Connectivity", "100M Water Resistant", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/ECB900DB_1A_Main.png"));
        watches.add(new Watch("EFSS570D_1A", "Casio", "Edifice", "Male",
                220.00, "Solar Powered", "200M Water Resistant", "Sapphire Glass", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/EFSS570D_1A_Main.png"));
        watches.add(new Watch("ECBS100HR_1A", "Casio", "Edifice", "Male",
                350.00, "Solar Powered", "100M Water Resistant", "Bluetooth smartphone link", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/ECBS100HR_1A_Main.png"));
        watches.add(new Watch("EFV620D_1A2V", "Casio", "Edifice", "Male",
                99.00, "Stainless Steel Band", "100M Water Resistant", "1/10th Second Stopwatch", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/EFV620D_1A2V_Main.png"));
        watches.add(new Watch("EFB680D_2BV", "Casio", "Edifice", "Male",
                190.00, "100M Water Resistant", "1/10th Second Stopwatch1/10th Second Stopwatch (60 mins)", " ", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/EFB680D_2BV_Main.png"));
        watches.add(new Watch("EFB680D_1AV", "Casio", "Edifice", "Male",
                180.00, "1/10th Second Stopwatch", "Water Resistant", "Sapphire Glass", 5, 0,"gs://shop-4ee63.appspot.com/Watches/Main/EFB680D_1AV_Main.png"));
//
//        ////////////////////////////////////////////////////////////////////////////////////////////
//        ////////////////////////////////////////////////////////////////////////////////////////////
//
//        //                          SETTING UP FIREBASE FIRESTORE
//
//        // Initialize Firebase Firestore
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    for (Watch watch : watches) {
        CollectionReference collectionReference = firestore.collection("watches");
        collectionReference.document(watch.getWatch_id()).set(watch)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Document added with ID: " + watch.getWatch_id());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////

    }
}


