package com.sinhvien.doan.LoginNRegis;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sinhvien.doan.FragmentParents.HomeFragment;
import com.sinhvien.doan.R;

public class Verity_OTP extends AppCompatActivity {
    EditText Code1, Code2, Code3, Code4, Code5, Code6;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verity_otp);

        Code1 = findViewById(R.id.Code1);
        Code2 = findViewById(R.id.Code2);
        Code3 = findViewById(R.id.Code3);
        Code4 = findViewById(R.id.Code4);
        Code5 = findViewById(R.id.Code5);
        Code6 = findViewById(R.id.Code6);

        setupOTP();
        btn = (Button) findViewById(R.id.btnCreate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Verity_OTP.this, HomeFragment.class);
                startActivity(i);
            }
        });

    }
    private void setupOTP(){
        Code1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    Code2.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Code2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    Code3.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Code3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    Code4.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Code4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    Code5.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Code5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    Code6.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}