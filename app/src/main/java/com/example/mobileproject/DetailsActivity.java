package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {


    private TextView name;
    private TextView price;
    private TextView details;
    private ImageView heartImg;
    private ImageView goToBag;
    private ImageView goToWish;
    private Integer tester = 0;
    private ImageView imageView;


    Watch watch = new Watch();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        watch = intent.getParcelableExtra("watch");
        heartImg = findViewById(R.id.heart);
        imageView = findViewById(R.id.watchImage);

        goToBag = findViewById(R.id.goToBag);
        name = findViewById(R.id.nameWatch1);
        price = findViewById(R.id.priceWatch1);
        details = findViewById(R.id.detailsWatch1);
        name.setText(watch.getModel());
        price.setText(String.valueOf(watch.getCost()));
        details.setText(String.format("%s\n%s\n%s\n", watch.getAspect1(), watch.getAspect2(), watch.getAspect3()));
        imageView = findViewById(R.id.watchImage);


        Glide.with(this)
                .load(watch.getMainImageUrl())
                .into(imageView);



        goToBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the watch at the current position

                // Start the next activity and pass the watch object to it
                Intent intent = new Intent(v.getContext(), CartActivity.class);
//                        System.out.println(watch.getMainImageUrl());
                intent.putExtra("watch", watch);

                v.getContext().startActivity(intent);
            }
        });

    }





    public void heartOnClick(View view) {


        //heartImg.setVisibility(View.VISIBLE);
        String str = "added the watch to the wish list screen";
        String str2 = "deleted the watch from the wish list screen";

        if (tester == 0) {
            heartImg.setColorFilter(getResources().getColor(R.color.purple_700), android.graphics.PorterDuff.Mode.MULTIPLY);
            //heartImg.setVisibility(View.VISIBLE);
            tester = 1;
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            Intent sendingIntent = new Intent(this, WishlistActivity.class);
            sendingIntent.putExtra("watch", watch);
            startActivity(sendingIntent);


        } else if (tester == 1) {
            heartImg.setColorFilter(getResources().getColor(R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);
            //heartImg.setVisibility(View.VISIBLE);
            tester = 0;
            Toast.makeText(this, str2, Toast.LENGTH_SHORT).show();

        }

        heartImg.setVisibility(View.VISIBLE);


    }

}