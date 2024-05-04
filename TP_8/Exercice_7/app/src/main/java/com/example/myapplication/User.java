package com.example.myapplication;

import androidx.annotation.NonNull;

public class User {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String ConfirmPassword;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public User(String firstName, String lastName, String email, String password, String confirmPassword) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setConfirmPassword(confirmPassword);
    }

    @NonNull
    @Override
    public String toString() {
        return "FirstName : "+FirstName+", LastName : "+LastName+", Email : "+Email+", Password : "+Password+", ConfirmPassword : "+ConfirmPassword;
    }
}
