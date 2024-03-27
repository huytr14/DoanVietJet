package com.sinhvien.doan.Admin.ManagerTicketCard;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sinhvien.doan.Admin.IndexAdmin;
import com.sinhvien.doan.Admin.ManagerProfileUser.UpdateUser;
import com.sinhvien.doan.Admin.ManagerProfileUser.ViewAccount;
import com.sinhvien.doan.R;

public class ManagerTicket extends AppCompatActivity {

    ListView lvContact;
    SearchView searchView;
    ArrayAdapter<String> adapter;
    Button addTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerticket);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        lvContact = findViewById(R.id.listTicket);
        lvContact.setAdapter(adapter);

        addTicket = findViewById(R.id.addticket);
        addTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerTicket.this, CreateTrip.class);
                startActivity(intent);
            }
        });
        searchView = (SearchView) findViewById(R.id.Search);
        searchView.setQueryHint("Enter your...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ticket");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                    String key = data.getKey().toString();
                    String value = data.getValue().toString();
                    adapter.add(key+"\n"+value);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "LoadPost: onCancelled", databaseError.toException());
                // ...
            }
        });
    }
}