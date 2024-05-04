package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_2 extends Fragment {

    TextView point_a,point_b,resultat;

    public Fragment_2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        point_a = view.findViewById(R.id.point_a);
        point_b = view.findViewById(R.id.point_b);
        resultat = view.findViewById(R.id.resultat);
    }

    public void setData(String data1,String data2,String data3) {
        point_a.setText(data1);
        point_b.setText(data2);
        resultat.setText(data3);
    }
}