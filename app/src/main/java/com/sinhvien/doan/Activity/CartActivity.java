package com.sinhvien.doan.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sinhvien.doan.R;

public class CartActivity extends AppCompatActivity {

    TextView tvTitle,tvCount,tvPrice,tvVAT,tvTotal;
    ListView listView;
    Button btnPayNow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        String count=getIntent().getStringExtra("count");
        tvCount=findViewById(R.id.totalEachItem);
        tvVAT=findViewById(R.id.VATtxt);
        tvPrice=findViewById(R.id.Pricetxt);
        tvTitle=findViewById(R.id.Titletxt);
        tvTotal=findViewById(R.id.Totaltxt);
        tvCount.setText(count);
        tvTitle.setText("Ticket");
        int price=20;
        String a=String.valueOf(price);
        tvPrice.setText(a+"$");
        tvVAT.setText("10%");
        int total= (int) Math.round(((price+price*0.1)*100)/100);
        String b=String.valueOf(total);
        tvTotal.setText(b+"$");
        btnPayNow=findViewById(R.id.btnPayNow);
        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CartActivity.this,Index.class);
                startActivity(intent);
            }
        });
    }
}