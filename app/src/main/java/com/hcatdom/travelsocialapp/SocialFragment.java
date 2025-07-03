package com.hcatdom.travelsocialapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcatdom.travelsocialapp.R;
import com.hcatdom.travelsocialapp.TripAdapter;
import com.hcatdom.travelsocialapp.Trip;
import com.hcatdom.travelsocialapp.DetallesViaje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Fragment “Social” que muestra 10 viajes predeterminados de la Tierra Media.
 */
public class SocialFragment extends Fragment {
    private RecyclerView rvTrips;
    private TripAdapter adapter;

    public SocialFragment() {
        // Constructor vacío
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // 1) Inflar layout
        View root = inflater.inflate(R.layout.fragment_social, container, false);

        // 2) Configurar RecyclerView con Layout vertical
        rvTrips = root.findViewById(R.id.rvTrips);
        rvTrips.setLayoutManager(new LinearLayoutManager(getContext()));

        // 3) Crear adapter con callback para clic en imagen
        adapter = new TripAdapter(trip -> {
            Intent intent = new Intent(getContext(), DetallesViaje.class);
            intent.putExtra(DetallesViaje.EXTRA_TRIP, (Serializable) trip);
            startActivity(intent);
        });
        rvTrips.setAdapter(adapter);

        // 4) Cargar los 10 viajes de ejemplo
        loadLocalTrips();

        return root;
    }

    /** Rellena el adapter con 10 viajes hardcodeados */
    private void loadLocalTrips() {
        List<Trip> list = new ArrayList<>();

        list.add(new Trip(
                "1",
                "Viaje a la Comarca",
                "Recorre los verdes prados y colinas de Hobbiton.",
                "https://example.com/images/hobbiton.jpg",
                "La Comarca",
                System.currentTimeMillis(),
                "hobbit123"
        ));

        list.add(new Trip(
                "2",
                "Cascadas de Rivendel",
                "Explora los jardines y salones acuáticos de Imladris.",
                "https://example.com/images/rivendell.jpg",
                "Rivendel",
                System.currentTimeMillis() + 1000,
                "elfo456"
        ));

        list.add(new Trip(
                "3",
                "Montañas Nubladas",
                "Atraviesa pasajes y picos nevados en tu caravana.",
                "https://example.com/images/misty_mountains.jpg",
                "Montañas Nubladas",
                System.currentTimeMillis() + 2000,
                "enano789"
        ));

        list.add(new Trip(
                "4",
                "Anduin en barca",
                "Navega por el gran río Anduin hasta Gondor.",
                "https://example.com/images/anduin.jpg",
                "Río Anduin",
                System.currentTimeMillis() + 3000,
                "navegante321"
        ));

        list.add(new Trip(
                "5",
                "Minas Tirith al ocaso",
                "Contempla la ciudad blanca en lo alto de la colina.",
                "https://example.com/images/minastirith.jpg",
                "Minas Tirith",
                System.currentTimeMillis() + 4000,
                "guardián111"
        ));

        list.add(new Trip(
                "6",
                "Bosque Negro",
                "Atrévete entre árboles milenarios y sombras inquietantes.",
                "https://example.com/images/mirkwood.jpg",
                "Bosque Negro",
                System.currentTimeMillis() + 5000,
                "explorador222"
        ));

        list.add(new Trip(
                "7",
                "Isengard y su torre",
                "Visita la fortaleza en ruinas y el pozo de la torre de Orthanc.",
                "https://example.com/images/isengard.jpg",
                "Isengard",
                System.currentTimeMillis() + 6000,
                "ent333"
        ));

        list.add(new Trip(
                "8",
                "Lago de Esgaroth",
                "Descansa junto al lago del pueblo del Lago y su dragón.",
                "https://example.com/images/long_lake.jpg",
                "Lago Largo",
                System.currentTimeMillis() + 7000,
                "habitante444"
        ));

        list.add(new Trip(
                "9",
                "La Puerta Negra",
                "Camina al pie de la temida Mordor y su sombrío horizonte.",
                "https://example.com/images/mordor.jpg",
                "Mordor",
                System.currentTimeMillis() + 8000,
                "valiente555"
        ));

        list.add(new Trip(
                "10",
                "Refugio de Lothlórien",
                "Admira los mallorn dorados y los elfos en su santuario.",
                "https://example.com/images/lothlorien.jpg",
                "Lothlórien",
                System.currentTimeMillis() + 9000,
                "elfo666"
        ));

        adapter.setTrips(list);
    }
}