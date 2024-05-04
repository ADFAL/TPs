package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView collapse1,collapse2;
    Group groupe_1,groupe_2;

    boolean isCollapsed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collapse1 = findViewById(R.id.collapse);
        groupe_1 = findViewById(R.id.groupe_1);

        collapse2 = findViewById(R.id.collapse2);
        groupe_2 = findViewById(R.id.groupe_2);

        collapse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCollapsed) {
                    // If it's currently collapsed, make it visible and change image to collapse
                    groupe_1.setVisibility(View.VISIBLE);
                    collapse1.setImageResource(R.drawable.collapse);
                } else {
                    // If it's currently visible, make it invisible and change image to expand
                    groupe_1.setVisibility(View.GONE);
                    collapse1.setImageResource(R.drawable.expand);
                }
                // Toggle the state
                isCollapsed = !isCollapsed;
            }
        });

        collapse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCollapsed) {
                    groupe_2.setVisibility(View.VISIBLE);
                    collapse2.setImageResource(R.drawable.collapse);
                } else {
                    groupe_2.setVisibility(View.GONE);
                    collapse2.setImageResource(R.drawable.expand);
                }
                isCollapsed = !isCollapsed;
            }
        });

    }
}
