package com.sinhvien.doan.LoginNRegis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.sinhvien.doan.R;

import java.util.concurrent.TimeUnit;

public class LoginWithNumber extends AppCompatActivity {
    EditText SDT;
    Button mbutton;
    TextView loginwithemail;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_number);

        SDT = findViewById(R.id.inputPhone);
        mbutton = findViewById(R.id.buttonCout);
        progressBar = findViewById(R.id.progressBar);
        loginwithemail = findViewById(R.id.loginwithemail);
        loginwithemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginWithNumber.this,LoginWithEmail.class);
                startActivity(i);
            }
        });
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SDT.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginWithNumber.this,"enter phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mbutton.setVisibility(View.INVISIBLE);
                PhoneAuthProvider.getInstance().verifyPhoneNumber("+84" + SDT.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        LoginWithNumber.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                mbutton.setVisibility(View.VISIBLE);
                            }
                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                mbutton.setVisibility(View.VISIBLE);
                                Toast.makeText(LoginWithNumber.this,"Failed",Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                mbutton.setVisibility(View.VISIBLE);

                                Intent intent = new  Intent(getApplicationContext(),Verity_OTP.class);
                                intent.putExtra("verificationId", verificationId);
                                startActivity(intent);
                            }
                        });
            }
        });
    }
}