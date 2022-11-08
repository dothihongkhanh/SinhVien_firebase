package com.example.sinhvien_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText edtxtUsername;
    EditText edtxrPassword;
    AppCompatButton btnLogin;
    TextView txtvSignup;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        mAuth=FirebaseAuth.getInstance();

        txtvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(myIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    public void AnhXa(){
        edtxtUsername = (EditText) findViewById(R.id.editTextUserName);
        edtxrPassword= (EditText) findViewById(R.id.editTextPass);
        btnLogin=(AppCompatButton) findViewById(R.id.buttonLogin);
        txtvSignup=(TextView) findViewById(R.id.textViewSignup);
    }
    public void login(){
        String email = edtxtUsername.getText().toString();
        String password = edtxrPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            edtxtUsername.setError("Email cannot be empty");
            edtxtUsername.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            edtxrPassword.setError("Password cannot be empty");
            edtxrPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
}
