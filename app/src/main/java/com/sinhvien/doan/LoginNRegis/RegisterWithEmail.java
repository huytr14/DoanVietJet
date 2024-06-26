package com.sinhvien.doan.LoginNRegis;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sinhvien.doan.Activity.Index;
import com.sinhvien.doan.Class.User;
import com.sinhvien.doan.R;

public class RegisterWithEmail extends AppCompatActivity {
    EditText inputEmail, inputPassword;
    Button btnContinue;
    FirebaseAuth firebase;
    ProgressBar progressBar;
    TextView back;
    String phonenumber,fullName,Email,birthday,profession,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        firebase = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        back = findViewById(R.id.backtoLogin);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginWithEmail.class);
                startActivity(i);
            }
        });
        btnContinue = findViewById(R.id.btnCont);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(inputEmail.getText());
                password = String.valueOf(inputPassword.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterWithEmail.this,"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterWithEmail.this,"Enter phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                btnContinue.setVisibility(View.INVISIBLE);
                Email = inputEmail.getText().toString().trim();
                User users = new User(Email,phonenumber,fullName,birthday,profession,gender);
                firebase.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    btnContinue.setVisibility(View.VISIBLE);
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = firebase.getCurrentUser();
                                    Toast.makeText(RegisterWithEmail.this, "Created account successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterWithEmail.this, Index.class);
                                    startActivity(intent);
                                    firebase.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                progressBar.setVisibility(View.GONE);
                                                btnContinue.setVisibility(View.VISIBLE);
                                                // Sign in success, update UI with the signed-in user's information
                                                FirebaseUser user = firebase.getCurrentUser();
                                                Toast.makeText(RegisterWithEmail.this, "Created account successful, Please verify your email id", Toast.LENGTH_SHORT).show();
                                            }
                                            else {
                                                progressBar.setVisibility(View.GONE);
                                                btnContinue.setVisibility(View.VISIBLE);
                                                // If sign in fails, display a message to the user.
                                                Toast.makeText(RegisterWithEmail.this, "Account was existed ", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                                } else {
                                    progressBar.setVisibility(View.GONE);
                                    btnContinue.setVisibility(View.VISIBLE);
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RegisterWithEmail.this, "Account was existed ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}