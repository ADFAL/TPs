package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShowAndHide;
    Button btnReset;
    Button btnRed, btnGreen, btnBlue;
    Boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowAndHide = findViewById(R.id.btnShowAndHide);
        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);
        btnReset = findViewById(R.id.btnReset);

        btnRed.setVisibility(View.INVISIBLE);
        btnGreen.setVisibility(View.INVISIBLE);
        btnBlue.setVisibility(View.INVISIBLE);

        btnShowAndHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!click) {
                    btnShowAndHide.setText("hide colors");
                    btnRed.setVisibility(View.VISIBLE);
                    btnGreen.setVisibility(View.VISIBLE);
                    btnBlue.setVisibility(View.VISIBLE);
                    click = true;
                }
                else {
                    btnShowAndHide.setText("show colors");
                    btnRed.setVisibility(View.INVISIBLE);
                    btnGreen.setVisibility(View.INVISIBLE);
                    btnBlue.setVisibility(View.INVISIBLE);
                    click = false;
                }
            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            }
        });
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            }
        });
        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            }
        });
    }
}