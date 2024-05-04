package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondFragment extends Fragment {

    Button btnOk;
    TextView tvDigit;
    private int value1;
    private int value2;
    int  min = 0,max = 0;
    String text = "";

    public void setValue1(int value1) {
        this.value1 = value1;
        display();
    }

    public void setValue2(int value2) {
        this.value2 = value2;
        display();
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(int value) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("value2",value);
        args.putInt("value1",value);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            value2 = getArguments().getInt("value2");
            value1 = getArguments().getInt("value1");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnOk = view.findViewById(R.id.btnOk);
        tvDigit = view.findViewById(R.id.tvDigit);
        display();

        btnOk.setOnClickListener(v->{
            if (min>max){
                tvDigit.setText("Error !!!");
            }
            else {
                int number = (int) (Math.random() * (max - min + 1) + min);
                tvDigit.setText(Integer.toString(number));
            }
        });
    }

    private void display() {
        min = this.value1;
        max = this.value2;
        text = "Generate between "+min+" and "+max;
        btnOk.setText(text);
    }
}