package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnValueChanged{

    FirstFragment frameLayout1,frameLayout2,frameLayout3;
    TextView displayColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayColor = findViewById(R.id.displayColor);
        frameLayout1 = new FirstFragment();
        frameLayout2 = new FirstFragment();
        frameLayout3 = new FirstFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout1,frameLayout1,"RED").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout2,frameLayout2,"GREEN").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout3,frameLayout3,"BLUE").commit();

        displayColor.setBackgroundColor(Color.rgb(frameLayout1.getColor(),frameLayout2.getColor(),frameLayout3.getColor()));
    }

    @Override
    public void onChanged() {
        int red = frameLayout1.getColor();
        int green = frameLayout2.getColor();
        int blue = frameLayout3.getColor();
        displayColor.setBackgroundColor(Color.rgb(red,green,blue));
    }
}