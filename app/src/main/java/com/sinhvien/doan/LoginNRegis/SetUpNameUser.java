package com.sinhvien.doan.LoginNRegis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sinhvien.doan.Activity.Index;
import com.sinhvien.doan.R;

public class SetUpNameUser extends AppCompatActivity {

    EditText nameUser;
    Button btnCreate;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setname);

        nameUser = findViewById(R.id.inputName);
        progressBar = findViewById(R.id.progressBar);
        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                btnCreate.setVisibility(View.INVISIBLE);
                if(nameUser.getText().toString().length() != 0){
                    Intent i = new Intent(SetUpNameUser.this, Index.class);
                    startActivity(i);
                }
                if(nameUser.getText().toString().length() == 0){
                    progressBar.setVisibility(View.GONE);
                    btnCreate.setVisibility(View.VISIBLE);
                    Toast.makeText(SetUpNameUser.this,"Enter your name",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}