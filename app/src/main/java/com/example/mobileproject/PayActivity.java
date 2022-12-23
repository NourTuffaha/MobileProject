package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {


    private EditText edtGmail;
    private EditText edtPassword;
    private EditText edtCreditCard;

    private String gmail;
    private String password;
    private String creditCardNum;
    Watch watch = new Watch();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Intent intent = getIntent();
        watch = intent.getParcelableExtra("watch");

        edtGmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtCreditCard = findViewById(R.id.edtCardNum);
    }

    public void btnOnclickPayment(View view) {
        gmail = edtGmail.getText().toString();
        password = edtPassword.getText().toString();
        creditCardNum = edtCreditCard.getText().toString();
        //to testing just
        String str = gmail + password + creditCardNum;
        Toast.makeText(this, "The payment operation successful", Toast.LENGTH_SHORT).show();

    }
}