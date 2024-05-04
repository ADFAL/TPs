package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int month = calendar.get(Calendar.MONTH) + 1;
    int year = calendar.get(Calendar.YEAR);


    Button back,next;
    TextView dayView,monthView,yearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

        dayView = findViewById(R.id.day);
        monthView = findViewById(R.id.month);
        yearView = findViewById(R.id.year);

        updateDateViews();

        dayView.setText(String.valueOf(day));
        monthView.setText(String.valueOf(month));
        yearView.setText(String.valueOf(year));


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.add(Calendar.DAY_OF_MONTH, -1);
                updateDateViews();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                updateDateViews();
            }
        });

    }

    private void updateDateViews() {
        if (calendar.after(Calendar.getInstance())) {
            calendar = Calendar.getInstance();
        }

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);

        dayView.setText(String.valueOf(day));
        monthView.setText(String.valueOf(month));
        yearView.setText(String.valueOf(year));
    }

}