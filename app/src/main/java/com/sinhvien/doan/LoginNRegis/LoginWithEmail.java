package com.sinhvien.doan.LoginNRegis;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sinhvien.doan.FragmentParents.HomeFragment;
import com.sinhvien.doan.R;

public class LoginWithEmail extends AppCompatActivity {

    EditText inputEmail, inputPassword;
    Button btnContinue;
    FirebaseAuth firebase;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebase.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(LoginWithEmail.this, HomeFragment.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_email);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        firebase = FirebaseAuth.getInstance();
        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(inputEmail.getText());
                password = String.valueOf(inputPassword.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginWithEmail.this,"enter phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                firebase.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginWithEmail.this,"Login successful",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginWithEmail.this, HomeFragment.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(LoginWithEmail.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}