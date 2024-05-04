package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    Button btnCheckAll, btnUncheckAll, btnReverse, btnDisplay;
    CheckBox[] checkBoxes = new CheckBox[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheckAll = findViewById(R.id.btnCheckAll);
        btnUncheckAll = findViewById(R.id.btnUncheckAll);
        btnReverse = findViewById(R.id.btnReverse);
        btnDisplay = findViewById(R.id.btnDisplay);

        for (int i = 0; i < 10; i++) {
            int checkBoxId = getResources().getIdentifier("checkBox" + (i + 1), "id", getPackageName());
            checkBoxes[i] = findViewById(checkBoxId);
        }
        
        btnCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CheckBox checkBox : checkBoxes) {
                    checkBox.setChecked(true);
                }
            }
        });

        btnUncheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CheckBox checkBox : checkBoxes) {
                    checkBox.setChecked(false);
                }
            }
        });

        btnReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CheckBox checkBox : checkBoxes) {
                    checkBox.setChecked(!checkBox.isChecked());
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean Checked = false;
                String selectedLanguages = "";

                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isChecked()) {
                        Checked = true;
                        selectedLanguages += checkBox.getText() + "\n";
                    }
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(Checked ? R.drawable.thumbs_up : R.drawable.thumbs_down);
                builder.setTitle("Your preferred languages");
                builder.setMessage(Checked ? selectedLanguages.trim() : "None!!!");
                builder.setPositiveButton("OK", null);
                builder.setCancelable(false);
                builder.show();
            }
        });
    }
}
