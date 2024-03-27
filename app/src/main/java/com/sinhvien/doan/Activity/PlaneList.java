package com.sinhvien.doan.Activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sinhvien.doan.Booking.MainActivity;
import com.sinhvien.doan.R;

public class PlaneList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayAdapter<String> list;
    ListView listView;
    TextView tv123;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_list);
        String from=getIntent().getStringExtra("from");
        String to=getIntent().getStringExtra("to");
        list = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        listView = findViewById(R.id.plane_list);
        listView.setAdapter(list);
        if(from.equals("Hà Nội")&&to.equals("TP Hồ Chí Minh")){
            hnsg();
        }
        else if(from.equals("Hà Nội")&&to.equals("Đồng Tháp")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Hà Nội").child("Đồng Tháp");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Hà Nội")&&to.equals("Đồng Nai")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Hà Nội").child("Đồng Nai");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Hà Nội")&&to.equals("Cần Thơ")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Hà Nội").child("Cần Thơ");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("TP Hồ Chí Minh")&&to.equals("Đồng Tháp")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("TP Hồ Chí Minh").child("Đồng Tháp");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("TP Hồ Chí Minh")&&to.equals("Đồng Nai")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("TP Hồ Chí Minh").child("Đồng Nai");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("TP Hồ Chí Minh")&&to.equals("Cần Thơ")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("TP Hồ Chí Minh").child("Cần Thơ");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Đồng Tháp")&&to.equals("Đồng Nai")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Đồng Tháp").child("Đồng Nai");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Đồng Tháp")&&to.equals("Cần Thơ")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Đồng Tháp").child("Cần Thơ");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Đồng Nai")&&to.equals("Cần Thơ")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Đồng Nai").child("Cần Thơ");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Đồng Tháp")&&to.equals("Hà Nội")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Đồng Tháp").child("Hà Nội");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Đồng Nai")&&to.equals("Hà Nội")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Đồng Nai").child("Hà Nội");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Cần Thơ")&&to.equals("Hà Nội")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Cần Thơ").child("Hà Nội");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Đồng Tháp")&&to.equals("TP Hồ Chí Minh")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Đồng Tháp").child("TP Hồ Chí Minh");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Đồng Nai")&&to.equals("TP Hồ Chí Minh")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Đồng Nai").child("TP Hồ Chí Minh");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Cần Thơ")&&to.equals("TP Hồ Chí Minh")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Cần Thơ").child("TP Hồ Chí Minh");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Đồng Nai")&&to.equals("Đồng Tháp")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Đồng Nai").child("Đồng Tháp");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Cần Thơ")&&to.equals("Đồng Tháp")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Cần Thơ").child("Đồng Tháp");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("Cần Thơ")&&to.equals("Đồng Nai")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("Cần Thơ").child("Đồng Nai");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }
        else if(from.equals("TP Hồ Chí Minh")&&to.equals("Hà Nội")){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Ticket").child("TP Hồ Chí Minh").child("Hà Nội");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list.clear();
                    for (DataSnapshot data: dataSnapshot.getChildren()) {
                        String key = data.getKey().toString();
                        String value = data.getValue().toString();
                        list.add(key+"\n"+value);
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                    // ...
                }
            });
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(PlaneList.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        }

    }
    private void hnsg(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ticket").child("Hà Nội").child("TP Hồ Chí Minh");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                    String key = data.getKey().toString();
                    String value = data.getValue().toString();
                    list.add(key+"\n"+value);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                // ...
            }
        });
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(PlaneList.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}