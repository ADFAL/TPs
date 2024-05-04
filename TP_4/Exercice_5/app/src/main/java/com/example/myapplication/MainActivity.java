package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAddition,btnSoustraction,btnMultiplication,btnDivision,btnResultat;
    EditText nombre1,nombre2;
    TextView operation,resultat;
    double nbr1=0.0,nbr2=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddition = findViewById(R.id.btnAddition);
        btnSoustraction = findViewById(R.id.btnSoustraction);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnDivision = findViewById(R.id.btnDivision);
        btnResultat = findViewById(R.id.btnResultat);

        nombre1 = findViewById(R.id.nombre1);
        nombre2 = findViewById(R.id.nombre2);

        operation = findViewById(R.id.operation);
        resultat = findViewById(R.id.resultat);


        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("+");
            }
        });

        btnSoustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("-");
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("*");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("/");
            }
        });

        btnResultat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre1.getText().toString().isEmpty() || nombre2.getText().toString().isEmpty()) {
                    resultat.setText("Problem !!!");
                    resultat.setTextColor(Color.RED);
                }
                else {
                    nbr1 = Double.parseDouble(nombre1.getText().toString());
                    nbr2 = Double.parseDouble(nombre2.getText().toString());

                    resultat.setTextColor(Color.GREEN);

                    if (operation.getText().toString().equals("+")){
                        resultat.setText(String.valueOf(nbr1+nbr2));
                    }
                    else if (operation.getText().toString().equals("-")){
                        resultat.setText(String.valueOf(nbr1-nbr2));
                    }
                    else if (operation.getText().toString().equals("*")){
                        resultat.setText(String.valueOf(nbr1*nbr2));
                    }
                    else if (operation.getText().toString().equals("/")){
                        if (nbr2 == 0) {
                            resultat.setText("Problem !!!");
                            resultat.setTextColor(Color.RED);
                        }
                        else {
                            resultat.setText(String.valueOf(nbr1/nbr2));
                        }
                    }
                }
            }
        });

    }
}