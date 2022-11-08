package com.example.sinhvien_firebase;

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

public class SignUpActivity extends AppCompatActivity {
    EditText edtxtUNsignup;
    EditText edtxtPWsignup;
    EditText edtxtEmail;
    EditText edtxtPhone;
    Button btnBackSU, btnSignUp;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        AnhXa();
        hideUnderBarInEditText(edtxtPWsignup);

        btnBackSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

    }

    public void AnhXa(){
        edtxtUNsignup=(EditText) findViewById(R.id.editTextUserNameSU);
        edtxtPWsignup=(EditText)  findViewById(R.id.editTextPassSU);
        edtxtEmail=(EditText) findViewById(R.id.editTextEmail);
        edtxtPhone=(EditText) findViewById(R.id.editTextSDT);
        btnBackSU=(Button)  findViewById(R.id.buttonBackSU);
        btnSignUp=(Button) findViewById(R.id.buttonSignUp);
    }
    public void hideUnderBarInEditText(EditText editText){
        editText.setBackgroundResource(android.R.color.transparent);
    }
    private void createUser(){
        String email = edtxtUNsignup.getText().toString();
        String password = edtxtPWsignup.getText().toString();

        if (TextUtils.isEmpty(email)){
            edtxtUNsignup.setError("Email cannot be empty");
            edtxtUNsignup.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            edtxtPWsignup.setError("Password cannot be empty");
            edtxtPWsignup.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(SignUpActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}