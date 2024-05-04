package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Fragment_1 extends Fragment {

    EditText editPoint,editX,editY;

    public Fragment_1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editPoint = view.findViewById(R.id.editPoint);
        editX = view.findViewById(R.id.editX);
        editY = view.findViewById(R.id.editY);
    }

    public String[] getData() {
        String[] Table = new String[3];
        Table[0] = editPoint.getText().toString();
        Table[1] = editX.getText().toString();
        Table[2] = editY.getText().toString();
        return Table;
    }
}

