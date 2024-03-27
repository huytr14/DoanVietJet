package com.sinhvien.doan.Activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("User");
        DatabaseReference userRef = rootRef.child(FirebaseAuth.getInstance().getUid());

        userRef.addValueEventListener(new ValueEventListener() {
            String phonenumber,fullName,Email,birthday,profession,gender;
            @Override
            public void onDataChange(DataSnapshot keyId) {
                Email = keyId.child("Email").getValue(String.class);
                phonenumber = keyId.child("Phone").getValue(String.class);
                fullName = keyId.child("FullName").getValue(String.class);
                birthday = keyId.child("Birthday").getValue(String.class);
                profession = keyId.child("Profession").getValue(String.class);
                gender = keyId.child("Gender").getValue(String.class);
                tvPN.setText(phonenumber);
                tvFN.setText(fullName);
                tvEmail.setText(Email);
                tvBirthday.setText(birthday);
                tvProfession.setText(profession);
                tvGender.setText(gender);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "Failed to read value", databaseError.toException());
                // ...
            }
        });

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