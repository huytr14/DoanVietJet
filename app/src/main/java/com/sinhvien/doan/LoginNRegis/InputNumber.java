package com.sinhvien.doan.LoginNRegis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sinhvien.doan.R;

public class InputNumber extends AppCompatActivity {
    Button mbutton;
    EditText mSDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_number);

        mSDT = (EditText) findViewById(R.id.inputPhone);
        mbutton = findViewById(R.id.buttonCout);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSDT.getText().length() != 0 && mSDT.getText().length() == 10)
                {
                    if(mSDT.getText().toString().length()==10)
                    {
                        Toast.makeText(InputNumber.this, "Đăng nhập thành công" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(InputNumber.this , InputPassWord.class);
                        startActivity(intent);
                    }
                    else if(mSDT.getText().toString().equals(mSDT)){
                        Toast.makeText(InputNumber.this,"Sai mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(mSDT.getText().length() == 0)
                {
                    Toast.makeText(InputNumber.this,"Mời bạn nhập", Toast.LENGTH_SHORT).show();
                }
                else if(mSDT.getText().length() != 10){
                    Toast.makeText(InputNumber.this,"Không phải số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Bundle bundle=getIntent().getExtras();
        if(bundle !=null){
            if(bundle.getString("some")!=null){
                Toast.makeText(getApplicationContext(),"data:"+bundle.getString("some"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}