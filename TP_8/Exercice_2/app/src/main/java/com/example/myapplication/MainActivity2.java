package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btnOk;
    TextView textView;
    EditText editNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnOk = findViewById(R.id.btnOk);
        textView = findViewById(R.id.textView);
        editNumber = findViewById(R.id.editNumber);

        editNumber.setText(getIntent().getStringExtra("nbr"));

        String text = getIntent().getStringExtra("btn");
        textView.setText(text);

        btnOk.setOnClickListener(v->{
            if (editNumber.getText().toString().isEmpty()) {
                Toast.makeText(this,"Something went wrong !!!",Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent();
                intent.putExtra("number",Integer.parseInt(editNumber.getText().toString()));
                if (text.equals("First Number")) {
                    setResult(1,intent);
                }
                else {
                    setResult(2,intent);
                }
                finish();
            }
        });

    }
}