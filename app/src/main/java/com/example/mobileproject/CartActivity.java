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

public class CartActivity extends AppCompatActivity {

    private ArrayList<String> cartList = new ArrayList<>();

    private TextView bagItemListTextView;
    private Button checkoutBtn;

    private double totalCost = 0.0;

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
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

        bagItemListTextView = findViewById(R.id.bagtv);
        checkoutBtn = findViewById(R.id.checkoutbtn);


        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void initRecyclerView() {

        mrecyclerView=findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList);
        mrecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {

        userList = new ArrayList<>();

//        userList.add(new ModelClass(R.drawable.gi,"Anjali","How are you?","10:45 am","_______________________________________"));
//
//        userList.add(new ModelClass(R.drawable.bo,"Brijesh","I am fine","15:08 pm","_______________________________________"));
//
//        userList.add(new ModelClass(R.drawable.boy,"Sam","You Know?","1:02 am","_______________________________________"));
//
//        userList.add(new ModelClass(R.drawable.girl,"Divya","How are you?","12:55 pm","_______________________________________"));
//
//        userList.add(new ModelClass(R.drawable.gi,"Simran","This is Easy","13:50 am","_______________________________________"));
//
//        userList.add(new ModelClass(R.drawable.boy,"Karan","I am Don","1:08 am","_______________________________________"));
//
//        userList.add(new ModelClass(R.drawable.bo,"Sameer","You Know this?","4:02 am","_______________________________________"));

    }
}
