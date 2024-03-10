package com.sinhvien.doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class InputNumberPhone extends AppCompatActivity {
    EditText SDT;
    Button mbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_number);

        SDT = (EditText) findViewById(R.id.inputPhone);
        mbutton = findViewById(R.id.buttonCout);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SDT.getText().toString().trim().isEmpty()){
                    Toast.makeText(InputNumberPhone.this,"enter phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                mbutton.setVisibility(View.INVISIBLE);
                PhoneAuthProvider.getInstance().verifyPhoneNumber("+84" + SDT.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        InputNumberPhone.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                mbutton.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                mbutton.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(verificationId, forceResendingToken);
                                mbutton.setVisibility(View.INVISIBLE);
                                Intent intent = new Intent(getApplicationContext(), SetUpNameUser.class);
                                startActivity(intent);
                            }
                        });
            }
        });
    }
}