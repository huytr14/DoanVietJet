package com.sinhvien.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mbutton;
    EditText mSDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSDT = (EditText) findViewById(R.id.inputPhone);
        mbutton = findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSDT.getText().length() != 0 && mSDT.getText().length() == 10)
                {
                    if(mSDT.getText().toString().length()==10)
                    {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this , InputPass.class);
                        startActivity(intent);
                    }
                    else if(mSDT.getText().toString().equals(mSDT)){
                        Toast.makeText(MainActivity.this,"Sai mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(mSDT.getText().length() == 0)
                {
                    Toast.makeText(MainActivity.this,"Mời bạn nhập", Toast.LENGTH_SHORT).show();
                }
                else if(mSDT.getText().length() != 10){
                    Toast.makeText(MainActivity.this,"Không phải số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}