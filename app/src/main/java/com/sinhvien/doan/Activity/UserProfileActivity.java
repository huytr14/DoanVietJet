package com.sinhvien.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sinhvien.doan.R;

public class UserProfileActivity extends AppCompatActivity {

    Button btnUP;
    TextView tvPN,tvFN,tvEmail,tvGender,tvBirthday,tvProfession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        btnUP=findViewById(R.id.btnUP);
        tvPN=findViewById(R.id.tvPhoneNumber1);
        tvFN=findViewById(R.id.tvFullName1);
        tvEmail=findViewById(R.id.tvEmail1);
        tvGender=findViewById(R.id.tvGender1);
        tvBirthday=findViewById(R.id.tvBirthday1);
        tvProfession=findViewById(R.id.tvProfession1);

        btnUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=getIntent().getStringExtra("phonenumber");
                tvPN.setText(n);
                Intent intent = new Intent(UserProfileActivity.this, UpdateProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}