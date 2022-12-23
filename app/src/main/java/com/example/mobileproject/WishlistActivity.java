package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WishlistActivity extends AppCompatActivity {

    private ArrayList<String> wishlistList = new ArrayList<>();

    private TextView bagItemListTextView;
    private Button cartbtn;
    private Button removeBtn;

    private double totalCost = 0.0;

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> watchList;
    Adapter adapter;
    Watch watch = new Watch();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initData();
        initRecyclerView();
        Intent intent = getIntent();
        watch = intent.getParcelableExtra("watch");

        wishlistList = new ArrayList<>();
        bagItemListTextView = findViewById(R.id.bagtv);
        cartbtn = findViewById(R.id.checkButton);
        //     removeBtn = findViewById(R.id.removeFromCartImg);

//        File img= null;
//        Watch watch = new Watch(12, "casio",15.00, "casio", "2021","M",img);

        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendingIntent = new Intent(WishlistActivity.this, CartActivity.class);
                sendingIntent.putExtra("watch", watch);
                startActivity(sendingIntent);
            }
        });
    }

    private void initRecyclerView() {

        mrecyclerView=findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(watchList);
        mrecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {

        watchList = new ArrayList<>();
        watchList.add(new ModelClass(R.drawable.gstb4001alarge,watch.getAspect1(),"900",R.drawable.trash));
        watchList.add(new ModelClass(R.drawable.gstb4001alarge,watch.getAspect1(),"900",R.drawable.trash));
        watchList.add(new ModelClass(R.drawable.gstb4001alarge,watch.getAspect1(),"900",R.drawable.trash));




    }
}