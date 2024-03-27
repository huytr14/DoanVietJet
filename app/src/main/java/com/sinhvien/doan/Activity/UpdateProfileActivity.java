package com.sinhvien.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sinhvien.doan.Class.User;
import com.sinhvien.doan.R;

public class UpdateProfileActivity extends AppCompatActivity {

    EditText edtPN,edtFN,edtEmail,edtBirthday,edtProfession;
    Button btnUpdate;
    ImageButton imageButton;
    DatabaseReference userDBReference;
    Spinner spinnerLanguages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        userDBReference= FirebaseDatabase.getInstance().getReference().child("User");
        edtPN=findViewById(R.id.edtPhoneNumber);
        edtFN=findViewById(R.id.edtFullName);
        edtEmail=findViewById(R.id.edtEmail);
        edtBirthday=findViewById(R.id.edtBirthday);
        edtProfession=findViewById(R.id.edtProfession);
        btnUpdate=findViewById(R.id.btnUP3);
        spinnerLanguages=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLanguages.setAdapter(adapter);



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber= edtPN.getText().toString();
                String fullName = edtFN.getText().toString();
                String email = edtEmail.getText().toString();
                String birthday = edtBirthday.getText().toString();
                String profession = edtProfession.getText().toString();
                String gender = spinnerLanguages.getSelectedItem().toString();
                User user = new User(phonenumber,fullName,email,birthday,profession,gender);
                userDBReference.child(FirebaseAuth.getInstance().getUid()).child("FullName").setValue(fullName);
                userDBReference.child(FirebaseAuth.getInstance().getUid()).child("Phone").setValue(phonenumber);
                userDBReference.child(FirebaseAuth.getInstance().getUid()).child("Birthday").setValue(birthday);
                userDBReference.child(FirebaseAuth.getInstance().getUid()).child("Profession").setValue(profession);
                userDBReference.child(FirebaseAuth.getInstance().getUid()).child("Gender").setValue(gender);
                Toast.makeText(UpdateProfileActivity.this,"Data inserted",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(UpdateProfileActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}