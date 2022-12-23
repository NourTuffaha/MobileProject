package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;

public class AllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        Watch[] watchArray = FileManager.watchArray;
        ImageView watch1 = findViewById(R.id.watch1);
        ImageView watch2 = findViewById(R.id.watch2);
        ImageView watch3 = findViewById(R.id.watch3);
        ImageView watch4 = findViewById(R.id.watch4);

        EditText cost1 = findViewById(R.id.cost1);
        EditText cost2 = findViewById(R.id.cost2);
        EditText cost3 = findViewById(R.id.cost3);
        EditText cost4 = findViewById(R.id.cost4);

        Watch watch = new Watch("GMAS120MF_202", "Casio", "G-Shock", "Male", 130.00, "Magnetic Resistant", " ", "200M Water Resistant");


        try {
            FileManager.read();
            watchArray = FileManager.watchArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        cost1.setText(watchArray[3].getBrand());

    }


}