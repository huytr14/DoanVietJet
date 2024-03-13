package com.sinhvien.doan.LoginNRegis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sinhvien.doan.Activity.Index;
import com.sinhvien.doan.R;

public class SetUpNameUser extends AppCompatActivity {

    EditText nameUser;
    Button btnCreate;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setname);

        nameUser = findViewById(R.id.inputName);
        progressBar = findViewById(R.id.progressBar);
        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                btnCreate.setVisibility(View.INVISIBLE);
                if(nameUser.getText().toString().length() != 0){
                    Intent i = new Intent(SetUpNameUser.this, Index.class);
                    startActivity(i);
                }
                if(nameUser.getText().toString().length() == 0){
                    progressBar.setVisibility(View.GONE);
                    btnCreate.setVisibility(View.VISIBLE);
                    Toast.makeText(SetUpNameUser.this,"Enter your name",Toast.LENGTH_SHORT);
                }
            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }
    }
}