package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        Watch[] watchArray = MainActivity.watchArray;

        ImageView watch1 = findViewById(R.id.watchImage);
        ImageView watch2 = findViewById(R.id.watch2);
        ImageView watch3 = findViewById(R.id.watch3);
        ImageView watch4 = findViewById(R.id.watch4);

        EditText cost1 = findViewById(R.id.cost1);
        EditText cost2 = findViewById(R.id.cost2);
        EditText cost3 = findViewById(R.id.cost3);
        EditText cost4 = findViewById(R.id.cost4);


        cost1.setText(String.valueOf(watchArray[0].getCost()));
        cost2.setText(String.valueOf(watchArray[1].getCost()));
        cost3.setText(String.valueOf(watchArray[2].getCost()));
        cost4.setText(String.valueOf(watchArray[3].getCost()));

        watch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AllActivity.this, DetailsActivity.class);
                intent.putExtra("watch", watchArray[0]);
                startActivity(intent);
            }
        });     watch2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AllActivity.this, DetailsActivity.class);
                intent.putExtra("watch", watchArray[1]);
                startActivity(intent);

            }
        });     watch3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AllActivity.this, DetailsActivity.class);
                intent.putExtra("watch", watchArray[2]);
                startActivity(intent);
            }
        });     watch4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AllActivity.this, DetailsActivity.class);
                intent.putExtra("watch", watchArray[3]);
                startActivity(intent);
            }
        });

//        try {
//            FileManager.read();
//            watchArray = FileManager.watchArray;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }


}