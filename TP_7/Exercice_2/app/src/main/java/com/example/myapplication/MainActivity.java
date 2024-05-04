package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton,radioButton2;
    CheckBox checkBox;
    Spinner spinner;
    TextView textView1,textView2,textView3;
    EditText editNumber;
    Button btnCalculate;
    boolean married = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);

        checkBox = findViewById(R.id.checkBox);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        editNumber = findViewById(R.id.editNumber);
        btnCalculate = findViewById(R.id.btnCalculate);

        spinner = findViewById(R.id.spinner);
        ArrayList<Integer> al_nombres = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            al_nombres.add(i);
        }
        ArrayAdapter<Integer> aa_nombres = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,al_nombres);
        spinner.setAdapter(aa_nombres);

        checkBox.setEnabled(false);
        spinner.setEnabled(false);

        if (radioButton.isClickable()) {
            checkBox.setEnabled(true);
        }
        if (radioButton2.isClickable()) {
            checkBox.setEnabled(false);
        }

        radioButton.setOnClickListener(v->{
            editNumber.setEnabled(false);
            checkBox.setEnabled(true);
            spinner.setEnabled(false);

        });
        checkBox.setOnClickListener(v->{
            if (checkBox.isChecked()){
                spinner.setEnabled(true);
                married = true;
            }
            else {
                spinner.setEnabled(false);
                married = false;
            }
        });

        radioButton2.setOnClickListener(v->{
            editNumber.setEnabled(true);
            checkBox.setEnabled(false);
            spinner.setEnabled(false);
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i>1){
                    textView2.setText(R.string.t1);
                }
                else {
                    textView2.setText(R.string.textview2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnCalculate.setOnClickListener(v->{
            if (radioButton.isChecked()) {
                int nbr = (int) spinner.getSelectedItem();
                double salairedebase = 7000;
                if (married) {
                    for (int i = 0; i < 6; i++) {
                        if (nbr == i) {
                            salairedebase += i * 200;
                            break;
                        }
                    }
                }
                textView3.setText(String.valueOf(salairedebase));
            }
            if (radioButton2.isChecked()) {
                if (editNumber.getText().toString().equals("")) {
                    textView3.setText(R.string.msg);
                }
                else {
                    double nbr = Integer.parseInt(editNumber.getText().toString()) * 100;
                    textView3.setText(String.valueOf(nbr));
                }
            }
        });
    }
}