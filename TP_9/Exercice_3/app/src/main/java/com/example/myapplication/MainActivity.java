package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kotlin.jvm.internal.Ref;

public class MainActivity extends AppCompatActivity {

    EditText editMin,editMax,editInterval;
    Button btnStart;
    TextView displayNumber;
    CounterRunnable counterRunnable;
    Handler handler = new Handler();

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
            btnStart.setEnabled(false);
            String min = editMin.getText().toString();
            String max = editMax.getText().toString();
            String interval = editInterval.getText().toString();
            if (min.isEmpty() || max.isEmpty() || interval.isEmpty()) {
                Toast.makeText(this, "Error :  [editMin or editMax or editInterval] is Empty", Toast.LENGTH_SHORT).show();
                btnStart.setEnabled(true);
            }
            else {
                if (Integer.parseInt(min) < 0 ||  Integer.parseInt(max) < 0 || Integer.parseInt(interval) < 0) {
                    Toast.makeText(this, "Error :  InvalidArgsException", Toast.LENGTH_SHORT).show();
                    btnStart.setEnabled(true);
                }
                else {
                    if (Integer.parseInt(min) > Integer.parseInt(max)) {
                        Toast.makeText(this, "Error :  Min biggerThan Max", Toast.LENGTH_SHORT).show();
                        btnStart.setEnabled(true);
                    }
                    else {
                        counterRunnable = new CounterRunnable(Integer.parseInt(min),Integer.parseInt(max),Integer.parseInt(interval));
                        handler.post(counterRunnable);
                        btnStart.setEnabled(false);
                    }
                }
            }
        });

    }

    class CounterRunnable implements Runnable {
        private int min,max,interval;
        public CounterRunnable(int min,int max,int interval) {
            this.min = min;
            this.max = max;
            this.interval = interval;
        }
        @Override
        public void run() {

            int counter = Integer.parseInt(displayNumber.getText().toString());
            counter--;
            displayNumber.setText(String.valueOf(counter));

            if (counter >= min) {
                handler.postDelayed(this,interval);
            }
            else {
                displayNumber.setText(String.valueOf(max));
                btnStart.setEnabled(true);
            }
        }
    }
}