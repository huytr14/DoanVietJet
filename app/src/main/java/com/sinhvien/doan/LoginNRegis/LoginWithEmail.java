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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.sinhvien.doan.Admin.IndexAdmin;
import com.sinhvien.doan.FragmentParents.HomeFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sinhvien.doan.Activity.Index;
import com.sinhvien.doan.R;

import java.util.HashMap;

public class LoginWithEmail extends AppCompatActivity {

    EditText inputEmail, inputPassword;
    Button btnContinue;
    FirebaseAuth firebase;
    FirebaseDatabase firebaseDatabase;
    ProgressBar progressBar;
    TextView  Create;
    Button btnGoogle;
    GoogleSignInClient googleSignInClient;
    int RC_SIGN_IN=20;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebase.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(LoginWithEmail.this, Index.class);
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
        Create = findViewById(R.id.btnCreate);
        firebase = FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        progressBar = findViewById(R.id.progressBar);
        btnContinue = findViewById(R.id.btnContinue);
        btnGoogle=findViewById(R.id.btnGoogle);
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();
        googleSignInClient= GoogleSignIn.getClient(this,gso);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSignIn();
            }
        });
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterWithEmail.class);
                startActivity(i);
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(inputEmail.getText());
                password = String.valueOf(inputPassword.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginWithEmail.this,"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginWithEmail.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                btnContinue.setVisibility(View.INVISIBLE);
                firebase.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(inputEmail.getText().toString().equals("admin123")&&inputPassword.getText().toString().equals("toiladuccong")){
                                    Intent a=new Intent(LoginWithEmail.this, IndexAdmin.class);
                                    startActivity(a);
                                }else {
                                    if (task.isSuccessful()) {
                                        if(firebase.getCurrentUser().isEmailVerified()){
                                            progressBar.setVisibility(View.GONE);
                                            btnContinue.setVisibility(View.VISIBLE);
                                            Toast.makeText(LoginWithEmail.this,"Login successful",Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(LoginWithEmail.this, Index.class);
                                            startActivity(intent);
                                            finish();
                                        }

                                    } else {
                                        progressBar.setVisibility(View.GONE);
                                        btnContinue.setVisibility(View.VISIBLE);
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(LoginWithEmail.this, "Login failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
            }
        });
    }
    private void googleSignIn(){
        Intent intent=googleSignInClient.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount>task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());
            }
            catch (Exception e){
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void firebaseAuth(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebase.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebase.getCurrentUser();
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("id", user.getUid());
                            map.put("name", user.getDisplayName());
                            map.put("profile", user.getPhotoUrl().toString());
                            firebaseDatabase.getReference().child("Google Login").child(user.getUid()).setValue(map);
                            Intent intent = new Intent(LoginWithEmail.this, Index.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginWithEmail.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}