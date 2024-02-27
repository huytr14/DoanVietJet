package com.sinhvien.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputPass extends AppCompatActivity {

    Button mbtnDN ;
    EditText mMK;
    TextView btnback , btnQMK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pass);

        mMK =(EditText) findViewById(R.id.inputPass);
        mbtnDN = (Button) findViewById(R.id.btnDN);
        mbtnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InputPass.this, Index.class);
                startActivity(intent);
            }
        });
        btnback = findViewById(R.id.textViewBack);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InputPass.this, InputNumber.class);
                startActivity(i);
            }
        });
    }
}