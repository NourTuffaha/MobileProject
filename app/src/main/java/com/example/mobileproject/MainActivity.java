package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    public static Watch[] watchArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button allBtn = findViewById(R.id.allBtn);
        Button menBtn = findViewById(R.id.menBtn);
        Button womenBtn = findViewById(R.id.womenBtn);

        watchArray = new Watch[10];
//
//
//        try {
//            FileManager.read();
//            watchArray = FileManager.watchArray;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        DatabaseHelper myDB = new DatabaseHelper(MainActivity.this);
//        for (int i = 0; i < watchArray.length; i++) {
//            myDB.addData(watchArray[i].getWatch_id(),
//                    watchArray[i].getBrand(),
//                    watchArray[i].getModel(),
//                    watchArray[i].getGender(),
//                    watchArray[i].getCost(),
//                    watchArray[i].getAspect1(),
//                    watchArray[i].getAspect2(),
//                    watchArray[i].getAspect3()
//            );
//        }

        Watch watch_1 = new Watch("ga2200m1a_large", "Casio", "G-Shock",
                "Male", 130.00, "Magnetic Resistant", " " +
                "", "200M Water Resistant");

        Watch watch_2 = new Watch("ga7004_large", "Casio", "G-Shock",
                "Male", 99.00, "", "Shock Resistant" +
                "", "200M Water Resistant");

        Watch watch_3 = new Watch("ga21007a", "Casio", "G-Shock",
                "Male", 99.00, "Water Resistant", " Shock Resistant " +
                "", "Front-Button Super Illuminator Light");

        Watch watch_4 = new Watch("gstb4001alarge", "Casio", "G-Shock",
                "Male", 130.00, " Carbon Core Guard Case", " Shock Resistant " +
                "", "200M Water Resistant");

        watchArray[0] = watch_1;
        watchArray[1] = watch_2;
        watchArray[2] = watch_3;
        watchArray[3] = watch_4;


        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllActivity.class);
                intent.putExtra("watchArray", watchArray);
                startActivity(intent);
            }
        });

    }
}