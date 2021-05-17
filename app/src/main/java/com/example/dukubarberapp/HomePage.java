package com.example.dukubarberapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageButton home = findViewById(R.id.home_button);
        ImageButton service = findViewById(R.id.services_button);
        ImageButton book = findViewById(R.id.book_button);
        ImageButton get = findViewById(R.id.get_button);

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServices();
            }
        });

    }

    public void openServices(){
        Intent intent = new Intent(this, PickMenu.class);
        startActivity(intent);
    }


}