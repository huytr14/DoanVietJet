package com.sinhvien.doan.Booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.doan.Activity.CartActivity;
import com.sinhvien.doan.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnSeatSelected {

    private static final int COLUMNS = 5;
    private TextView txtSeatSelected,tv10;
    int seat,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSeatSelected = (TextView)findViewById(R.id.txt_seat_selected);

        List<AbstractItem> items = new ArrayList<>();
        int a=40;
        for (int i=0; i<a; i++) {

            if (i%COLUMNS==0 || i%COLUMNS==4) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i%COLUMNS==1 || i%COLUMNS==3) {
                items.add(new CenterItem(String.valueOf(i)));
            } else {
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(new GridLayoutManager(this,COLUMNS));

        AirplaneAdapter adapter = new AirplaneAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onSeatSelected(int count) {
        txtSeatSelected.setText("Book "+count+" seats");
        String a=String.valueOf(count);
        txtSeatSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CartActivity.class);
                intent.putExtra("count",a);
                startActivity(intent);
            }
        });
    }
}
