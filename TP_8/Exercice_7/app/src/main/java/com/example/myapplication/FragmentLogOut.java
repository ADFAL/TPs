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

public class FragmentLogOut extends Fragment {

    TextView textViewUser;
    Button btnLogOut;
    String UserFullName;

    public FragmentLogOut() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_out, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewUser = view.findViewById(R.id.textViewUser);
        btnLogOut = view.findViewById(R.id.btnLogOut);

        textViewUser.setText(UserFullName);

        btnLogOut.setOnClickListener(v->{
            requireActivity().finish();
        });
    }

    public void setText(String userFullName) {
        this.UserFullName = userFullName;
    }
}