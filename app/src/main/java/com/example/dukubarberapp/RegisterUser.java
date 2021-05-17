package com.example.dukubarberapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterUser extends AppCompatActivity {

    TextView name, email, password;
    FirebaseAuth mAuth;
    ImageButton signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        name = findViewById(R.id.fullName);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.registerUser);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign_up_data();
            }
        });
    }

    private void sign_up_data() {

        String emailFinal = email.getText().toString();
        String passwordFinal = password.getText().toString();

        if(emailFinal.equals("")){
            email.setError("Invalid email");
        }
        if(passwordFinal.equals("")){
            email.setError("Invalid password");
        }

        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(emailFinal,passwordFinal).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Signup succesfully", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(RegisterUser.this, LogIn.class);
                    startActivity(intent);
                }
                else{
                    mAuth.createUserWithEmailAndPassword(emailFinal,passwordFinal).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Error!",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}