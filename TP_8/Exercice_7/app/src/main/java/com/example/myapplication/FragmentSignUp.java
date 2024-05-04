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

import java.util.ArrayList;

public class FragmentSignUp extends Fragment {

    EditText editFirstNameSignUp,editLastNameSignUp,editEmailSignUp,editPasswordSignUp,editConfirmPasswordSignUp;
    Button btnOkSignUp;
    ArrayList<User> data = new ArrayList<>();
    String FirstName,LastName,Email,Password,ConfirmPassword;

    public FragmentSignUp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sing_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editFirstNameSignUp = view.findViewById(R.id.editFirstNameSignUp);
        editLastNameSignUp = view.findViewById(R.id.editLastNameSignUp);
        editEmailSignUp = view.findViewById(R.id.editEmailSignUp);
        editPasswordSignUp = view.findViewById(R.id.editPasswordSignUp);
        editConfirmPasswordSignUp = view.findViewById(R.id.editConfirmPasswordSignUp);
        btnOkSignUp = view.findViewById(R.id.btnOkSignUp);


        btnOkSignUp.setOnClickListener(v->{

            FirstName = editFirstNameSignUp.getText().toString();
            LastName = editLastNameSignUp.getText().toString();
            Email = editEmailSignUp.getText().toString();
            Password = editPasswordSignUp.getText().toString();
            ConfirmPassword = editConfirmPasswordSignUp.getText().toString();

            if (!(FirstName.isEmpty()) && !(LastName.isEmpty()) && !(Email.isEmpty()) && !(Password.isEmpty()) && !(ConfirmPassword.isEmpty()) && Password.equals(ConfirmPassword)){
                User user = new User(FirstName,LastName,Email,Password,ConfirmPassword);
                data.add(user);
                System.out.println("FragmentSignUp : display data : "+data);
            }else {
                System.out.println("Error EditText isEmpty OR password is not equals to confirm password");
            }

        });
    }

    public ArrayList<User> getData() {
        return this.data;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
}