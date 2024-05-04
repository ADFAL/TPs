package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editLink;
    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLink = findViewById(R.id.editLink);
        btnOpen = findViewById(R.id.btnOpen);

        btnOpen.setOnClickListener(v -> {
            String link = editLink.getText().toString();
            String regex = "(https?://)?(www\\.)?(.*)";
            if (link.matches(regex)) {
                if (!link.startsWith("http")) {
                    if (link.startsWith("www.")) {
                        link = "https://" + link;
                        editLink.setText(link);
                    } else {
                        link = "https://www." + link;
                        editLink.setText(link);
                    }
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "There is no app that open the link !!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}