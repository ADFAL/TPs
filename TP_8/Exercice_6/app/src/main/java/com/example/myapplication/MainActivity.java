package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Fragment_1 fragment1,fragment2;
    Fragment_2 fragment3;

    Button btnOk;

    String text1,text_Point1,text_x1,text_y1;
    String text2,text_Point2,text_x2,text_y2;

    double resultat = 0;
    String text_resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment_1();
        fragment2 = new Fragment_1();
        fragment3 = new Fragment_2();

        getSupportFragmentManager().beginTransaction().add(R.id.Fragment1,fragment1,null).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.Fragment2,fragment2,null).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.FragmentContainer3,fragment3,null).commit();

        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(v->{
            String[] data1 = fragment1.getData();
            String[] data2 = fragment2.getData();

            String point1 = data1[0];
            String x1 = data1[1];
            String y1 = data1[2];

            String point2 = data2[0];
            String x2 = data2[1];
            String y2 = data2[2];

            text_Point1 = (point1.isEmpty()) ? "?" : point1 ;
            text_x1 = (x1.isEmpty()) ? "?" : x1 ;
            text_y1 = (y1.isEmpty()) ? "?" : y1 ;

            text_Point2 = (point2.isEmpty()) ? "?" : point2 ;
            text_x2 = (x2.isEmpty()) ? "?" : x2 ;
            text_y2 = (y2.isEmpty()) ? "?" : y2 ;

            text1 = String.format("%s(%s,%s)",text_Point1,text_x1,text_y1);
            text2 = String.format("%s(%s,%s)",text_Point2,text_x2,text_y2);

            if (!(point1.isEmpty() || x1.isEmpty() || y1.isEmpty() || point2.isEmpty() || x2.isEmpty() || y2.isEmpty())) {
                resultat = Math.sqrt(Math.pow(Integer.parseInt(x2) - Integer.parseInt(x1),2) + Math.pow(Integer.parseInt(y2) - Integer.parseInt(y1),2));
                text_resultat = String.format("%.2f",resultat);
            }
            else {
                text_resultat = "?";
            }

            fragment3.setData(text1,text2,text_resultat);
        });
    }
}
