package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.onValueChanged{

    FirstFragment firstFragment1,firstFragment2;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment1 = new FirstFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView,firstFragment1,null).commit();

        firstFragment2 = new FirstFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView2,firstFragment2,null).commit();

        secondFragment = SecondFragment.newInstance(firstFragment1.getValue());
        secondFragment = SecondFragment.newInstance(firstFragment2.getValue());
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView3,secondFragment,null).commit();

    }

    @Override
    public void onChanged() {
        int min = firstFragment1.getValue();
        int max = firstFragment2.getValue();
        secondFragment.setValue2(max);
        secondFragment.setValue1(min);
    }
}