package com.sinhvien.doan.Admin.ManagerTicketCard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sinhvien.doan.Activity.TicketBus;
import com.sinhvien.doan.Admin.ManagerProfileUser.UpdateUser;
import com.sinhvien.doan.Admin.ManagerProfileUser.ViewAccount;
import com.sinhvien.doan.Booking.MainActivity;
import com.sinhvien.doan.BookingTicket.Ticket;
import com.sinhvien.doan.Class.User;
import com.sinhvien.doan.R;

import java.util.Calendar;

public class CreateTrip extends AppCompatActivity {

    String item, item2, item3, sDate, check;
    EditText quanlity, total, id;
    TextView date;
    Button create;
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView2, autoCompleteTextView3;

    String[] Routes = new String[]
            {"0h-3h30", "2h-5h30", "4h-7h30", "8h-11h30", "12h-15h30", "16h-19h30"};
    String[] Locations = new String[]
            {"Hà Nôi",
                    "TP. Hồ Chí Minh",
                    "Đồng Nai",
                    "Đồng Tháp",
                    "Sóc Trăng",
                    "Bạc Liêu",
                    "Cà Mau",
                    "Lâm Đồng",
                    "Vũng Tàu",
                    "Tiền Giang",
                    "An Giang",
                    "Kiên Giang",
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trip);

        date = (TextView) findViewById(R.id.edtDate);
        autoCompleteTextView = findViewById(R.id.filled_exposed_dropdown);
        autoCompleteTextView2 = findViewById(R.id.filled_exposed_dropdown2);
        quanlity = findViewById(R.id.edtQuanlity);
        total = findViewById(R.id.edtTotal);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        CreateTrip.this,
                        R.layout.dropdown_item,
                        Locations);

        autoCompleteTextView.setAdapter(adapter);
        final ArrayAdapter<String> adapter2 =
                new ArrayAdapter<>(
                        CreateTrip.this,
                        R.layout.dropdown_item,
                        Locations);

        autoCompleteTextView2.setAdapter(adapter2);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();

            }
        });

        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item2 = adapterView.getItemAtPosition(i).toString();
            }
        });

        autoCompleteTextView3 = findViewById(R.id.filled_exposed_dropdown3);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<>(CreateTrip.this, R.layout.dropdown_item, Routes);
        autoCompleteTextView3.setAdapter(adapter3);
        autoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item3 = adapterView.getItemAtPosition(i).toString();
            }
        });

        create = (Button) findViewById(R.id.Create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String Id = null;
                    String Quanlity = quanlity.getText().toString();
                    String Start = autoCompleteTextView.getText().toString();
                    String Come = autoCompleteTextView2.getText().toString();
                    String Total = total.getText().toString();
                    String Seat = null;
                    String Date = date.getText().toString();
                    String Route = autoCompleteTextView3.getText().toString();
                    Ticket ticket = new Ticket(Id, Quanlity, Start, Come, Total, Seat, Route,Date);
                    DatabaseReference userDBReference = FirebaseDatabase.getInstance().getReference().child("Ticket").child(Date).child(Route);
                    userDBReference.child("Quanlity").setValue(Quanlity);
                    userDBReference.child("Start").setValue(Start);
                    userDBReference.child("Come").setValue(Come);
                    userDBReference.child("Total").setValue(Total);
                    Toast.makeText(CreateTrip.this, "Add Trip Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Toast.makeText(CreateTrip.this, "Error:" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        selectDate();
    }

    private void selectDate() {
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog = new DatePickerDialog(CreateTrip.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                        sDate = (dayofmonth + "/" + month + "/" + year);
                        check = sDate;

                        date.setText(check);
                    }
                }, year, month, day
                );
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });
    }
}