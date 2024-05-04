package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    NumericUpDownFragment numericUpDownFragment1,numericUpDownFragment2,numericUpDownFragment3;
    Button btnOk;
    TextView displayColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = findViewById(R.id.btnOk);
        displayColor = findViewById(R.id.displayColor);

        numericUpDownFragment1 = new NumericUpDownFragment();
        numericUpDownFragment2 = new NumericUpDownFragment();
        numericUpDownFragment3 = new NumericUpDownFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frNumericUpDown,numericUpDownFragment1,null).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frNumericUpDown2,numericUpDownFragment2,null).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frNumericUpDown3,numericUpDownFragment3,null).commit();

        btnOk.setOnClickListener(v->{
            int red = numericUpDownFragment1.getValue();
            int green = numericUpDownFragment2.getValue();
            int blue = numericUpDownFragment3.getValue();
            displayColor.setBackgroundColor(Color.rgb(red,green,blue));
        });
    }
}