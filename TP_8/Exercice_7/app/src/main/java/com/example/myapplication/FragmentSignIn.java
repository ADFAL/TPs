package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentSignIn extends Fragment {

    EditText editEmailSingIn,editPasswordSingIn;
    Button btnOkSignIn;
    ArrayList<User> data;
    String Email,Password;
    String FirstName,LastName;

    public FragmentSignIn() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editEmailSingIn = view.findViewById(R.id.editEmailSingIn);
        editPasswordSingIn = view.findViewById(R.id.editPasswordSingIn);
        btnOkSignIn = view.findViewById(R.id.btnOkSignIn);

        editEmailSingIn.setText(Email);
        editPasswordSingIn.setText(Password);

        btnOkSignIn.setOnClickListener(v->{

            Intent intent = new Intent(getActivity(),MainActivity2.class);
            Email = editEmailSingIn.getText().toString();
            Password = editPasswordSingIn.getText().toString();

            if (!(Email.isEmpty() && Password.isEmpty())) {
                if (data.get(0).getEmail().equals(Email) && data.get(0).getPassword().equals(Password)) {
                    System.out.println("FragmentSignIn : True -> Email and Password valid");
                    FirstName = data.get(0).getFirstName().substring(0,1).toUpperCase() + data.get(0).getFirstName().substring(1).toLowerCase();
                    LastName = data.get(0).getLastName().toUpperCase();
                    intent.putExtra("full_name",FirstName+" "+LastName);
                    startActivity(intent);
                }
                else {
                    System.out.println("FragmentSignIn : False -> Email or Password Invalid");
                }
            }
            else {
                System.out.println("Email or Password is Empty");
            }

        });
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}