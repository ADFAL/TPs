package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private onValueChanged parentActivity;
    private Button btnDecrement,btnIncrement;
    private TextView tvValue;
    private int min = 10;
    private int max = 20;
    private int value = min;

    public int getValue() {
        return this.value;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnDecrement = view.findViewById(R.id.btnDecrement);
        btnIncrement = view.findViewById(R.id.btnIncrement);
        tvValue = view.findViewById(R.id.tvValue);

        tvValue.setText("10");

        btnDecrement.setOnClickListener(v->{
            if (value>min) {
                value--;
                tvValue.setText(Integer.toString(value));
                parentActivity.onChanged();
            }
        });

        btnIncrement.setOnClickListener(v->{
            if (value<max) {
                value++;
                tvValue.setText(Integer.toString(value));
                parentActivity.onChanged();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        parentActivity = (onValueChanged) getActivity();
    }

    interface onValueChanged {
        void onChanged();
    }

}