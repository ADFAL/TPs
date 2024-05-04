package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editEmail,editPassword,editConfirmPassword,editSalution,editFirstName,editLastName,editJour,editMois,editAnnee,editIndicatifTelephonique,editChiffreTelephonique;
    Button btnSubmit;
    ArrayList<String> list = new ArrayList<>(Arrays.asList("mr", "miss", "ms"));
    int jour,moins,annee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
        editSalution = findViewById(R.id.editSalution);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editJour = findViewById(R.id.editJour);
        editMois = findViewById(R.id.editMois);
        editAnnee = findViewById(R.id.editAnnee);
        editIndicatifTelephonique = findViewById(R.id.editIndicatifTelephonique);
        editChiffreTelephonique = findViewById(R.id.editChiffreTelephonique);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "";

                if (editEmail.getText().toString().isEmpty()) {
                    text += "- Email required.";
                }
                else {
                    if (editEmail.getText().toString().matches("\\w+@\\w+.\\w{2,3}")) {
                        text += "";
                    }
                    else {
                        text += "- Email Invalid.";
                    }
                }

                if (editPassword.getText().toString().isEmpty()) {
                    text += "\n- Password required.";
                }
                else  {
                    text += "";
                }

                if (editConfirmPassword.getText().toString().isEmpty()) {
                    text += "\n- Confirm password required.";
                }
                else {
                    text += "";
                }

                if (!editPassword.getText().toString().isEmpty() && !editConfirmPassword.getText().toString().isEmpty()) {
                    if (editPassword.getText().toString().equals(editConfirmPassword.getText().toString())) {
                        text += "";
                    }
                    else {
                        text += "- Password and confirm password does not match.";
                    }
                }

                if (!editSalution.getText().toString().isEmpty()) {
                    if (list.contains(editSalution.getText().toString().toLowerCase())) {
                        text += "OK";
                    }
                    else {
                        text += "- Salutation invalid.";
                    }
                }

                if (!editJour.getText().toString().isEmpty() || !editMois.getText().toString().isEmpty() || !editAnnee.getText().toString().isEmpty()) {

                    try {
                        jour = Integer.parseInt(editJour.getText().toString());
                        moins = Integer.parseInt(editMois.getText().toString());
                        annee = Integer.parseInt(editAnnee.getText().toString());
                    }
                    catch (Exception e) {
                        jour = 0;
                        moins = 0;
                        annee = 0;
                    }

                    String inputDate = String.format(jour+"-"+moins+"-"+annee);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        Date parsedDate = simpleDateFormat.parse(inputDate);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(parsedDate);
                        if (valid(inputDate, calendar)) {
                            text += "OK";
                        } else {
                            text += "- Date of birth invalid.";
                        }
                    } catch (Exception e) {
                        text += "- Date of birth invalid.";
                    }

                }

                String IndicatifTelephonique = editIndicatifTelephonique.getText().toString();
                String ChiffreTelephonique = editChiffreTelephonique.getText().toString();

                if (!IndicatifTelephonique.isEmpty() && ChiffreTelephonique.isEmpty()) {
                    text += "- Phone invalid.";
                }
                else {
                    text += "";
                }
                if (IndicatifTelephonique.isEmpty() && !ChiffreTelephonique.isEmpty()) {
                    text += "- Area code invalid.";
                }
                else {
                    text += "";
                }
                if (!IndicatifTelephonique.isEmpty() && !ChiffreTelephonique.isEmpty()) {
                    System.out.println("premier : "+Pattern.matches("\\d{1,3}",IndicatifTelephonique));
                    System.out.println("deuxieme : "+Pattern.matches("\\d{10}",ChiffreTelephonique));
                    if (!Pattern.matches("\\d{1,3}",IndicatifTelephonique)) {
                        text += "- Area code invalid.";
                    }
                    else {
                        text += "";
                    }
                    if (!Pattern.matches("\\d{10}",ChiffreTelephonique)) {
                        text += "- Phone invalid.";
                    }
                    else {
                        text += "";
                    }
                }
                else {
                    text += "";
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(text);

                if (!text.equals("")) {
                    builder.show();
                }
                else {
                    builder.setMessage("Hello "+editFirstName.getText().toString()+" "+editLastName.getText().toString()+"\n-I won 20,000 dirhams ");
                    builder.show();
                }

            }
        });
    }

    private boolean valid(String input, Calendar calendar) {

        int jour = calendar.get(Calendar.DAY_OF_MONTH);
        int moins = calendar.get(Calendar.MONTH) + 1;
        int annee = calendar.get(Calendar.YEAR);

        return  input.contains(Integer.toString(jour))
                &&
                input.contains(Integer.toString(moins))
                &&
                input.contains(Integer.toString(annee));
    }
}