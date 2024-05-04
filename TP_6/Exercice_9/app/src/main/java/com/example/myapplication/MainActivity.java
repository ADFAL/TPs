package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnAdd, btnSub, btnMul, btnReset, btnCheck;
    EditText editNumber1, editNumber2;
    private Placeholder placeholder;
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeholder = findViewById(R.id.placeholder);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnReset = findViewById(R.id.btnReset);
        btnCheck = findViewById(R.id.btnCheck);
        editNumber1 = findViewById(R.id.editNumber1);
        editNumber2 = findViewById(R.id.editNumber2);

        editNumber1.requestFocus();
        btnAdd.setOnClickListener(v -> {
            if (placeholder.getContent() == btnAdd) {
                if (editNumber1.getText().toString().isEmpty() || editNumber2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Problem", Toast.LENGTH_SHORT).show();
                }
                else {
                    int resultat = Integer.parseInt(editNumber1.getText().toString()) + Integer.parseInt(editNumber2.getText().toString());
                    Toast.makeText(MainActivity.this, String.valueOf(resultat), Toast.LENGTH_SHORT).show();
                }
            }
            swapView(btnAdd);
            operation = "add";
        });
        btnAdd.performClick();

        btnSub.setOnClickListener(v -> {
            if (placeholder.getContent() == btnSub) {
                if (editNumber1.getText().toString().isEmpty() || editNumber2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Problem", Toast.LENGTH_SHORT).show();
                }
                else {
                    int resultat = Integer.parseInt(editNumber1.getText().toString()) - Integer.parseInt(editNumber2.getText().toString());
                    Toast.makeText(MainActivity.this, String.valueOf(resultat), Toast.LENGTH_SHORT).show();
                }
            }
            swapView(btnSub);
            operation = "sub";
        });

        btnMul.setOnClickListener(v -> {
            if (placeholder.getContent() == btnMul) {
                if (editNumber1.getText().toString().isEmpty() || editNumber2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Problem", Toast.LENGTH_SHORT).show();
                }
                else {
                    int resultat = Integer.parseInt(editNumber1.getText().toString()) * Integer.parseInt(editNumber2.getText().toString());
                    Toast.makeText(MainActivity.this, String.valueOf(resultat), Toast.LENGTH_SHORT).show();
                }
            }
            swapView(btnMul);
            operation = "mul";
        });

        btnReset.setOnClickListener(v -> {
            editNumber1.setText("");
            editNumber2.setText("");
            editNumber1.requestFocus();
            swapView(btnAdd);
        });

        btnCheck.setOnClickListener(v -> {
            if (editNumber1.getText().toString().isEmpty() || editNumber2.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Problem", Toast.LENGTH_SHORT).show();
            } else {
                int num1 = Integer.parseInt(editNumber1.getText().toString());
                int num2 = Integer.parseInt(editNumber2.getText().toString());
                int result = 0;
                if (operation.equals("add")) {
                    result = num1 + num2;
                }
                else if (operation.equals("sub")) {
                    result = num1 - num2;
                }
                else {
                    result = num1 * num2;
                }
                Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void swapView(View v) {
        placeholder.setContentId(v.getId());
    }
}
