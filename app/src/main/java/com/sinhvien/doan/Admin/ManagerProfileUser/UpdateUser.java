package com.sinhvien.doan.Admin.ManagerProfileUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sinhvien.doan.Class.User;
import com.sinhvien.doan.R;

public class UpdateUser extends AppCompatActivity {

    EditText edtPhone, edtfullName, edtProfession, edtEmail, edtBirthday;
    Spinner Gender;
    Button Adduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        edtPhone = findViewById(R.id.edtPhone);
        edtfullName = findViewById(R.id.edtFullName);
        edtProfession = findViewById(R.id.edtProfession);
        edtEmail = findViewById(R.id.edtEmail);
        edtBirthday = findViewById(R.id.edtBirthday);
        Gender = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Gender.setAdapter(adapter);

        Adduser =(Button)findViewById(R.id.addnew);
        Adduser.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                try {
                    String phonenumber = edtPhone.getText().toString();
                    String fullName = edtfullName.getText().toString();
                    String email = edtEmail.getText().toString();
                    String birthday = edtBirthday.getText().toString();
                    String profession = edtProfession.getText().toString();
                    String gender = Gender.getSelectedItem().toString();
                    User user = new User(phonenumber,fullName,email,birthday,profession,gender);
                    DatabaseReference userDBReference = FirebaseDatabase.getInstance().getReference().child("User").child(fullName);
                    userDBReference.child("FullName").setValue(fullName);
                    userDBReference.child("Phone").setValue(phonenumber);
                    userDBReference.child("Birthday").setValue(birthday);
                    userDBReference.child("Profession").setValue(profession);
                    userDBReference.child("Gender").setValue(gender);

                    Toast.makeText(UpdateUser.this,"Add user Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(UpdateUser.this, ViewAccount.class);
                    startActivity(intent);
                }
                catch (Exception ex){
                    Toast.makeText(UpdateUser.this,"Error:" +ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
