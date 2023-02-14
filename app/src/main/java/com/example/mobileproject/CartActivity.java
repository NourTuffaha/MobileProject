package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayList<String> cartList = new ArrayList<>();

    private TextView bagItemListTextView;
    private Button checkoutBtn;
    private Button removeBtn;
    private Spinner spinner;

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

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        initData();
        initRecyclerView();

        Intent intent = getIntent();
        watch = intent.getParcelableExtra("watch");

        cartList = new ArrayList<>();
        bagItemListTextView = findViewById(R.id.bagtv);
        checkoutBtn = findViewById(R.id.checkButton);
        //     removeBtn = findViewById(R.id.removeFromCartImg);


        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendingIntent = new Intent(CartActivity.this, PayActivity.class);
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

        watchList.add(new ModelClass(R.drawable.gstb4001alarge,watch.getModel(),String.valueOf(watch.getCost()),R.drawable.trash));



    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String choice = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),choice, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}