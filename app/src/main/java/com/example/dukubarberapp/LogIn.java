package com.example.dukubarberapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    private EditText email, password;
    private FirebaseAuth mAuth;
    private ImageButton signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email = findViewById(R.id.Email_field);
        password = findViewById(R.id.passwprd);
        signIn = findViewById(R.id.singIn);
        mAuth = FirebaseAuth.getInstance();

        TextView register = findViewById(R.id.register);

        register.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                registerPage();
                break;
            case R.id.singIn:
                login();
                break;
        }
    }

    public void registerPage(){
        Intent intent = new Intent(this, RegisterUser.class);
        startActivity(intent);
    }

    private void login(){
        String emailFinal = email.getText().toString();
        String passwordFinal = password.getText().toString();
        mAuth.signInWithEmailAndPassword(emailFinal,passwordFinal).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(LogIn.this, "Sing in succesfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogIn.this, HomePage.class);
                    startActivity(intent);
                }
                else{
                    mAuth.signInWithEmailAndPassword(emailFinal,passwordFinal).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Failed to sign in!",Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
    }


}