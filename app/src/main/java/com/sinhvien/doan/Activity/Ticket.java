package com.sinhvien.doan.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.sinhvien.doan.R;

import java.util.ArrayList;
import java.util.Calendar;

public class Ticket extends AppCompatActivity {

    String item,item2,item3,sDate;
    Button search,datebtn;
    TextView i,sdate;
    String a,b,c,d;
    TextInputLayout startingdropdown,droppingdropdown;
    AutoCompleteTextView autoCompleteTextView,autoCompleteTextView2,autoCompleteTextView3;
    String check;
    ArrayList<String> buses = new ArrayList<>();

    String[] NumberTickets =new String[]
            {"1","2","3","4","5","6",};
    String[] Locations =new String[]
            {"Hà Nội",
                    "TP Hồ Chí Minh",
                    "Đồng Nai",
                    "Đồng Tháp",
                    "Cần Thơ",
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_plane);


        Intent x = getIntent();
        a = x.getStringExtra("name");
        b = x.getStringExtra("email");
        c = x.getStringExtra("number");
        d = x.getStringExtra("password");

        datebtn = findViewById(R.id.datebtn);
        startingdropdown = findViewById(R.id.text_input_layout1);
        droppingdropdown = findViewById(R.id.text_input_layout2);
        sdate = findViewById(R.id.textView8);

        autoCompleteTextView = findViewById(R.id.filled_exposed_dropdown);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Ticket.this, R.layout.dropdown_item, Locations);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
            }
        });

        autoCompleteTextView2 = findViewById(R.id.filled_exposed_dropdown2);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(Ticket.this, R.layout.dropdown_item, Locations);
        autoCompleteTextView2.setAdapter(adapter2);
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item2 = adapterView.getItemAtPosition(i).toString();
            }
        });

        autoCompleteTextView3 = findViewById(R.id.filled_exposed_dropdown3);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<>(Ticket.this, R.layout.dropdown_item, NumberTickets);
        autoCompleteTextView3.setAdapter(adapter3);
        autoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item3 = adapterView.getItemAtPosition(i).toString();
            }
        });


        selectDate();

        search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Ticket.this, PlaneList.class);
                intent.putExtra("from",item);
                intent.putExtra("to",item2);
                startActivity(intent);
            }
        });
    }
    private void selectDate(){
        Calendar calendar=Calendar.getInstance();
        final int year =calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog=new DatePickerDialog(Ticket.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                        sDate= dayofmonth + "/" + month + "/" + year;
                        check=sDate;

                        sdate.setText("Date: " + sDate);
                    }
                },year,month,day
                );
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() -1000);
                datePickerDialog.show();
            }
        });
    }
}