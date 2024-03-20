package com.sinhvien.doan.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sinhvien.doan.R;

public class UpdateProfileActivity extends AppCompatActivity {

    EditText edtPN,edtFN,edtEmail,edtBirthday,edtProfession;
    Button btnUpdate;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        edtPN=findViewById(R.id.edtPhoneNumber);
        edtFN=findViewById(R.id.edtFullName);
        edtEmail=findViewById(R.id.edtEmail);
        edtBirthday=findViewById(R.id.edtBirthday);
        edtProfession=findViewById(R.id.edtProfession);
        btnUpdate=findViewById(R.id.btnUP3);
        Spinner spinnerLanguages=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLanguages.setAdapter(adapter);



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber=edtPN.getText().toString().trim();
                String fullname=edtFN.getText().toString().trim();
                String email=edtEmail.getText().toString().trim();
                String birthday=edtBirthday.getText().toString().trim();
                String profession=edtProfession.getText().toString().trim();
                Intent intent=new Intent(UpdateProfileActivity.this, UserProfileActivity.class);
                intent.putExtra("phonenumber",phonenumber);
                intent.putExtra("fullname",fullname);
                intent.putExtra("email",email);
                intent.putExtra("birthday",birthday);
                intent.putExtra("profession",profession);
                startActivity(intent);
            }
        });

    }
}