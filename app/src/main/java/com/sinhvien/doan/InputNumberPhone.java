package com.sinhvien.doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputNumberPhone extends AppCompatActivity {
    EditText SDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_number);

        SDT = (EditText) findViewById(R.id.inputPhone);
        final Button mbutton = findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SDT.getText().toString().trim().isEmpty()){
                    Toast.makeText(InputNumberPhone.this,"enter phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                mbutton.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(), SetUpNameUser.class);
                startActivity(intent);
            }
        });
    }
}