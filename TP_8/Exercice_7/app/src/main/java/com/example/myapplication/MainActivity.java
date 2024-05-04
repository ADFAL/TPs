package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSingIn,btnSingUp;
    FragmentSignIn fragmentSignIn;
    FragmentSignUp fragmentSignUp;
    ArrayList<User> Data;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSingIn = findViewById(R.id.btnSingIn);
        btnSingUp = findViewById(R.id.btnSingUp);

        fragmentSignIn = new FragmentSignIn();
        fragmentSignUp = new FragmentSignUp();

        btnSingIn.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutLogOut,fragmentSignIn,null).commit();
            Data = fragmentSignUp.getData();
            email = fragmentSignUp.getEmail();
            password = fragmentSignUp.getPassword();
            fragmentSignIn.setEmail(email);
            fragmentSignIn.setPassword(password);
            fragmentSignIn.setData(Data);
            System.out.println("MainActivity : sign in "+Data);
        });

        btnSingUp.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayoutLogOut,fragmentSignUp,null).commit();
            System.out.println("MainActivity : sign up "+Data);
        });
    }
}