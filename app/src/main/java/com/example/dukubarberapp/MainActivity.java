package com.example.dukubarberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button_get = (ImageButton) findViewById(R.id.get_button);
        button_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogInPage();
            }
        });
    }



    public void openLogInPage(){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

}