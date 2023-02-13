package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private ImageView watchImage;


    Watch watch = new Watch();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        watch = intent.getParcelableExtra("watch");

        heartImg = findViewById(R.id.heart);
        watchImage = findViewById(R.id.watchImage);

        goToBag = findViewById(R.id.goToBag);
        goToWish = findViewById(R.id.goToWish);
        name = findViewById(R.id.nameWatch1);
        price = findViewById(R.id.priceWatch1);
        details = findViewById(R.id.detailsWatch1);
        name.setText(watch.getBrand());
        price.setText(String.valueOf(watch.getCost()));
        Glide.with(this)
                .load(watch.getMainImageUrl())

                .into(watchImage);
        details.setText(watch.getAspect1() + "\n" +
                watch.getAspect2() + "\n" +
                watch.getAspect3() + "\n"


        );



//        if (watch.getWatch_id() == "ga7004a_large")
//            watchImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ga7004a_large));
//
//
//        else if (watch.getWatch_id() == "ga2200m1a_large")
//            watchImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ga2200m1a_large));
//
//
//        else if (watch.getWatch_id() == "ga21007a")
//            watchImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ga21007a));
//
//        else if (watch.getWatch_id() == "gstb4001alarge")
//            watchImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gstb4001alarge));
//        else
//            watchImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.gstb4001alarge));



        goToBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        goToWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this,WishlistActivity.class);
                startActivity(intent);
            }
        });
    }




    public void btnAddToBagWatch1(View view) {

        Intent sendingIntent = new Intent(this, CartActivity.class);
        sendingIntent.putExtra("watch", watch);
        startActivity(sendingIntent);

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