package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView alps, cactus, grass, hazelnut, hops, iceberg, nut, palm, seawaves, tomato, tree, wheat,derniereImageView;
    TextView afficher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        afficher = findViewById(R.id.afficher);
        alps = findViewById(R.id.alps);
        cactus = findViewById(R.id.cactus);
        grass = findViewById(R.id.grass);
        hazelnut = findViewById(R.id.hazelnut);
        hops = findViewById(R.id.hops);
        iceberg = findViewById(R.id.iceberg);
        nut = findViewById(R.id.nut);
        palm = findViewById(R.id.palm);
        seawaves = findViewById(R.id.seawaves);
        tomato = findViewById(R.id.tomato);
        tree = findViewById(R.id.tree);
        wheat = findViewById(R.id.wheat);

        setColorAndText(alps);
        setColorAndText(cactus);
        setColorAndText(grass);
        setColorAndText(hazelnut);
        setColorAndText(hops);
        setColorAndText(iceberg);
        setColorAndText(nut);
        setColorAndText(palm);
        setColorAndText(seawaves);
        setColorAndText(tomato);
        setColorAndText(tree);
        setColorAndText(wheat);
    }
    public void setColorAndText(ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (derniereImageView != null) {
                    derniereImageView.setBackgroundColor(Color.TRANSPARENT);
                }
                imageView.setBackgroundColor(Color.GREEN);
                String text = getResources().getResourceEntryName(imageView.getId());
                afficher.setText(text);
                derniereImageView = imageView;
            }
        });
    }
}
