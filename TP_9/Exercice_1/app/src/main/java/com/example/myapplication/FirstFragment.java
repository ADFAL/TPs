package com.example.myapplication;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class FirstFragment extends Fragment {

    OnValueChanged parentActivity;
    Button btnDecrement,btnIncrement;
    EditText editNumber;
    ProgressBar progressBar;
    int min = 0,max = 255;
    int value = min;
    int color;

    public int getColor() {
        return color;
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
        editNumber = view.findViewById(R.id.editNumber);
        progressBar = view.findViewById(R.id.progressBar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            progressBar.setMin(min);
        }
        progressBar.setMax(max);

        if (getTag() != null) {
            switch (getTag()) {
                case "RED" :
                    progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
                    break;
                case "GREEN" :
                    progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case "BLUE" :
                    progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                    progressBar.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
                    break;
            }
        }

        editNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!(editNumber.getText().toString().isEmpty())) {
                    try {
                        int number = Integer.parseInt(editNumber.getText().toString());
                        if (number>max) {
                            value = 0;
                            progressBar.setProgress(value);
                            editNumber.setText("");
                        }
                        else if (number<min) {
                            value = 0;
                            progressBar.setProgress(value);
                            editNumber.setText("");
                        }
                        else {
                            value = number;
                            progressBar.setProgress(number);
                            color = value;
                            parentActivity.onChanged();
                        }
                    }
                    catch (Exception e) {
                        
                    }
                }
                else {
                    value = 0;
                    progressBar.setProgress(value);
                    color = value;
                }
            }
        });

        btnDecrement.setOnClickListener(v->{
            if (value > min) {
                value--;
                progressBar.incrementProgressBy(value);
                editNumber.setText(String.valueOf(value));
                color = value;
                parentActivity.onChanged();
            }
            else {
                value = 0;
                progressBar.setProgress(value);
                editNumber.setText(String.valueOf(value));
            }
        });

        btnIncrement.setOnClickListener(v->{
            if (value < max) {
                value++;
                progressBar.incrementProgressBy(value);
                editNumber.setText(String.valueOf(value));
                color = value;
                parentActivity.onChanged();
            }
            else {
                value = 0;
                progressBar.setProgress(value);
                editNumber.setText(String.valueOf(value));
                color = value;
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parentActivity = (OnValueChanged) getActivity();
    }

    interface OnValueChanged {
        void onChanged();
    }
}