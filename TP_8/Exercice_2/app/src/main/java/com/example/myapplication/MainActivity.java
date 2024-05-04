package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    ActivityResultLauncher<Intent> confirm;
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

        confirm = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 1) {
                            Intent data = result.getData();
                            if (data != null) {
                                textViewNbr1.setText(String.valueOf(data.getIntExtra("number",0)));
                                nbr1 = data.getIntExtra("number",0);
                            }
                        }
                        else if ((result.getResultCode() == 2)){
                            Intent data = result.getData();
                            if (data != null) {
                                textViewNbr2.setText(String.valueOf(data.getIntExtra("number",0)));
                                nbr2 = data.getIntExtra("number",0);
                            }
                        }
                    }
                }
        );

        btnFirst.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("btn",btnFirst.getText().toString());
            intent.putExtra("nbr",textViewNbr1.getText().toString());
            confirm.launch(intent);
        });

        btnSecond.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("btn",btnSecond.getText().toString());
            intent.putExtra("nbr",textViewNbr2.getText().toString());
            confirm.launch(intent);
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
}