package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editMin,editMax,editInterval;
    Button btnStart;
    TextView displayNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMin = findViewById(R.id.editMin);
        editMax = findViewById(R.id.editMax);
        editInterval = findViewById(R.id.editInterval);
        btnStart = findViewById(R.id.btnStart);
        displayNumber = findViewById(R.id.displayNumber);

        editMax.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    if (Integer.parseInt(editMax.getText().toString()) < 0) {
                        displayNumber.setText("?");
                    }
                    else {
                        displayNumber.setText(editMax.getText().toString());
                    }
                }
                catch (Exception e) {

                }
            }
        });

        btnStart.setOnClickListener(v->{
            if (editMin.getText().toString().isEmpty() || editMax.getText().toString().isEmpty() || editInterval.getText().toString().isEmpty()) {
                Toast.makeText(this, "Error :  [editMin or editMax or editInterval] is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                if (Integer.parseInt(editMin.getText().toString()) < 0 ||  Integer.parseInt(editMax.getText().toString()) < 0 || Integer.parseInt(editInterval.getText().toString()) < 0) {
                    Toast.makeText(this, "Error :  InvalidArgsException", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Integer.parseInt(editMin.getText().toString()) > Integer.parseInt(editMax.getText().toString())) {
                        Toast.makeText(this, "Error :  Min biggerThan Max", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        CounterThread counterThread = new CounterThread();
                        counterThread.start();
                    }
                }
            }
        });

    }

    class CounterThread extends Thread {

        int min = Integer.parseInt(editMin.getText().toString()) ,max = Integer.parseInt(editMax.getText().toString()),interval = Integer.parseInt(editInterval.getText().toString()) ;
        int i;

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    btnStart.setEnabled(false);
                }
            });

            for (i = max; i >= min; i--) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayNumber.setText(""+i);
                    }
                });

                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    btnStart.setEnabled(true);
                }
            });
        }
    }
}