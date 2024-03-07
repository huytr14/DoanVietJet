package com.sinhvien.doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText medt;
    Button btncout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        medt = findViewById(R.id.Name);
        btncout = findViewById(R.id.cout);
        btncout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(medt.getText().toString().length() != 0){
                    Intent i = new Intent(Register.this,InputOTP.class);
                    startActivity(i);
                }
            }
        });
    }
}