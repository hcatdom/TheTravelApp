package com.hcatdom.travelsocialapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetallesViaje extends AppCompatActivity {
    public static final String EXTRA_TRIP = "extra_trip";

    private Trip trip;
    private ImageView detailImg;
    private TextView detailTitle, detailLocation, detailUser, detailTime, detailDescription;
    private Button VerViaje;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        detailImg = findViewById(R.id.detailImg);
        detailTitle = findViewById(R.id.detailTitle);
        detailLocation = findViewById(R.id.detailLocation);
        detailUser = findViewById(R.id.detailUser);
        detailTime = findViewById(R.id.detailTime);
        detailDescription = findViewById(R.id.detailDescription);
        VerViaje = findViewById(R.id.VerViaje);

        if (getIntent().hasExtra(EXTRA_TRIP)) {
            Object obj = getIntent().getSerializableExtra(EXTRA_TRIP);
            if (obj instanceof Trip) trip = (Trip) obj;
        }

        if (trip != null) {
            detailTitle.setText(trip.getTitle());
            detailLocation.setText("Ubicación: " + trip.getLocation());
            detailUser.setText("Usuario: " + trip.getUserId());

            String tiempo;
            //Esto sirve para que el programa no colapse y elija correctamente cada viaje de los q hemos hecho
            switch (trip.getId()) {
                case "1": tiempo = "Por la mañana"; break;
                case "2": tiempo = "Tardeo"; break;
                case "3": tiempo = "A la luz de la taberna"; break;
                case "4": tiempo = "Bañados por la luz del amanecer"; break;
                default:  tiempo = "En algún momento de la jornada"; //pongo este de default por si queréis añadir más viajes
            }
            detailTime.setText("Hora de la Tierra Media: " + tiempo);
            detailDescription.setText(trip.getDescription());
            detailImg.setImageResource(trip.getImageResId());
        } else {
            detailTitle.setText("Detalle no disponible");
        }

        VerViaje.setOnClickListener(v -> {
            Intent intent = new Intent(DetallesViaje.this, MainActivity.class);
            intent.putExtra("abrirMapa", true);
            startActivity(intent);
        });
    }
}
