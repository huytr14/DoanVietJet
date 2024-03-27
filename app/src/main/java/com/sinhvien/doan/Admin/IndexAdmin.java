package com.sinhvien.doan.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sinhvien.doan.Admin.ManagerProfileUser.ViewAccount;
import com.sinhvien.doan.Admin.ManagerTicketCard.ManagerTicket;
import com.sinhvien.doan.R;

public class IndexAdmin extends AppCompatActivity {

    TextView viewAccount, managerTicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_admin);

        viewAccount =(TextView) findViewById(R.id.ViewAccount);
        viewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexAdmin.this, ViewAccount.class);
                startActivity(intent);
            }
        });
        managerTicket=findViewById(R.id.lstTicket);
        managerTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(IndexAdmin.this, ManagerTicket.class);
                startActivity(i);
            }
        });
        
    }
}