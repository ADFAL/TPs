package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    FragmentLogOut fragmentLogOut;
    String FullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FullName = getIntent().getStringExtra("full_name");
        fragmentLogOut = new FragmentLogOut();
        fragmentLogOut.setText(FullName);
        getSupportFragmentManager().beginTransaction().add(R.id.FrameLayoutLogOut,fragmentLogOut,null).commit();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}