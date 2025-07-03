package com.hcatdom.travelsocialapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hcatdom.travelsocialapp.R;
import com.hcatdom.travelsocialapp.Trip;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

public class DetallesViaje extends AppCompatActivity {
    public static final String EXTRA_TRIP = "extra_trip";

    private ImageView detailImg;
    private TextView detailTitle;
    private TextView detailLocation;
    private TextView detailDescription;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        // 1) Referencias a las vistas
        detailImg         = findViewById(R.id.detailImg);
        detailTitle       = findViewById(R.id.detailTitle);
        detailLocation    = findViewById(R.id.detailLocation);
        detailDescription = findViewById(R.id.detailDescription);

        // 2) Recuperar el Trip enviado desde el fragmento
        Trip trip = null;
        if (getIntent().hasExtra(EXTRA_TRIP)) {
            Object obj = getIntent().getSerializableExtra(EXTRA_TRIP);
            if (obj instanceof Trip) {
                trip = (Trip) obj;
            }
        }

        if (trip != null) {
            // 3) Rellenar datos
            detailTitle.setText(trip.getTitle());
            detailLocation.setText("Ubicación: " + trip.getLocation());
            detailDescription.setText(trip.getDescription());
            // 4) Descargar imagen
            new ImageLoadTask(detailImg).execute(trip.getImageUrl());
        } else {
            detailTitle.setText("Detalle no disponible");
        }
    }

    /**
     * Tarea asíncrona para descargar una imagen de la red
     * y asignarla al ImageView sin librerías externas.
     */
    private static class ImageLoadTask extends AsyncTask<String, Void, Bitmap> {
        private final ImageView imageView;

        ImageLoadTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urlString = urls[0];
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.connect();
                try (InputStream is = conn.getInputStream()) {
                    return BitmapFactory.decodeStream(is);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bmp) {
            if (bmp != null) {
                imageView.setImageBitmap(bmp);
            } else {
                imageView.setImageResource(android.R.drawable.stat_notify_error);
            }
        }
    }
}