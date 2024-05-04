package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnFirst,btnSecond,btnAdd,btnSub,btnMul;
    TextView textViewNbr1,textViewNbr2;
    public static final int REQUEST_CODE_FIRST = 100;
    public static final int REQUEST_CODE_SECOND = 200;
    int nbr1 = 0 , nbr2 = 0, resultat = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        textViewNbr1 = findViewById(R.id.textViewNbr1);
        textViewNbr2 = findViewById(R.id.textViewNbr2);

        btnFirst.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("textView",String.valueOf(btnFirst.getText()));
            intent.putExtra("nbr",textViewNbr1.getText().toString());
            startActivityForResult(intent,REQUEST_CODE_FIRST);
        });

        btnSecond.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("textView",String.valueOf(btnSecond.getText()));
            intent.putExtra("nbr",textViewNbr2.getText().toString());
            startActivityForResult(intent,REQUEST_CODE_SECOND);
        });

        btnAdd.setOnClickListener(v->{
             resultat = nbr1 + nbr2;
            Toast.makeText(this,String.format("%d + %d = %d",nbr1,nbr2,resultat),Toast.LENGTH_SHORT).show();
        });
        btnSub.setOnClickListener(v->{
            resultat = nbr1 - nbr2;
            Toast.makeText(this,String.format("%d - %d = %d",nbr1,nbr2,resultat),Toast.LENGTH_SHORT).show();
        });
        btnMul.setOnClickListener(v->{
            resultat = nbr1 * nbr2;
            Toast.makeText(this,String.format("%d * %d = %d",nbr1,nbr2,resultat),Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            if (requestCode == REQUEST_CODE_FIRST) {
                textViewNbr1.setText(String.valueOf(data.getIntExtra("number",0)));
                nbr1 = data.getIntExtra("number",0);
            }
            else if (requestCode == REQUEST_CODE_SECOND) {
                textViewNbr2.setText(String.valueOf(data.getIntExtra("number",0)));
                nbr2 = data.getIntExtra("number",0);
            }
        }
    }
}