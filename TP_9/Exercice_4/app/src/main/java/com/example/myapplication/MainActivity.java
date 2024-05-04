package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
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
    CounterAsyncTask counterAsyncTask;

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
            String min = editMin.getText().toString();
            String max = editMax.getText().toString();
            String interval = editInterval.getText().toString();
            if (min.isEmpty() || max.isEmpty() || interval.isEmpty()) {
                Toast.makeText(this, "Error :  [editMin or editMax or editInterval] is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                if (Integer.parseInt(min) < 0 ||  Integer.parseInt(max) < 0 || Integer.parseInt(interval) < 0) {
                    Toast.makeText(this, "Error :  InvalidArgsException", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Integer.parseInt(min) > Integer.parseInt(max)) {
                        Toast.makeText(this, "Error :  Min biggerThan Max", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        counterAsyncTask = new CounterAsyncTask();
                        counterAsyncTask.execute(Integer.parseInt(min),Integer.parseInt(max),Integer.parseInt(interval));
                    }
                }
            }
        });

    }

    class CounterAsyncTask extends AsyncTask<Integer,Integer,Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            btnStart.setEnabled(false);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int min = integers[0],max = integers[1],interval = integers[2];
            for (int i = max; i >= min; i--) {
                publishProgress(i);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            displayNumber.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            btnStart.setEnabled(true);
        }

        @Override
        protected void onCancelled(Integer integer) {
            super.onCancelled(integer);
        }
    }
}