package com.sinhvien.doan.LoginNRegis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sinhvien.doan.Activity.Index;
import com.sinhvien.doan.R;

public class SetUpNameUser extends AppCompatActivity {

    EditText nameUser;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setname);

        nameUser = findViewById(R.id.inputName);
        btnNext = findViewById(R.id.button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameUser.getText().toString().length() != 0){
                    Intent i = new Intent(SetUpNameUser.this, Index.class);
                    startActivity(i);
                }
            }
        });
    }
}