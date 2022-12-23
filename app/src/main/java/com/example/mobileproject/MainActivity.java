package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button allBtn = findViewById(R.id.allBtn);
        Button menBtn = findViewById(R.id.menBtn);
        Button womenBtn = findViewById(R.id.womenBtn);

        Watch[] watchArray = new Watch[10];


        try {
            FileManager.read();
            watchArray = FileManager.watchArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DatabaseHelper myDB = new DatabaseHelper(MainActivity.this);
        for (int i = 0; i < watchArray.length; i++) {
            myDB.addData(watchArray[i].getWatch_id(),
                    watchArray[i].getBrand(),
                    watchArray[i].getModel(),
                    watchArray[i].getGender(),
                    watchArray[i].getCost(),
                    watchArray[i].getAspect1(),
                    watchArray[i].getAspect2(),
                    watchArray[i].getAspect3()
            );

        }
        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AllActivity.class));
            }
        });

    }
}