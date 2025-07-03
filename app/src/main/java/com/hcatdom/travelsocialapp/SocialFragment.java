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
                "Viaje de aventura a las montañas azules",
                "Vacaciones a base de rutitas visitando los parajes del norte.",
                R.drawable.bluemountains,
                "La Comarca",
                System.currentTimeMillis(),
                "hobbit123"
        ));

        list.add(new Trip(
                "2",
                "Cascadas de Rivendel",
                "Explora los jardines y salones acuáticos de Imladris.",
                R.drawable.bluemountains,
                "Rivendel",
                System.currentTimeMillis() + 1000,
                "elfo456"
        ));

        list.add(new Trip(
                "3",
                "Montañas Nubladas",
                "Atraviesa pasajes y picos nevados en tu caravana.",
                R.drawable.bluemountains,
                "Montañas Nubladas",
                System.currentTimeMillis() + 2000,
                "enano789"
        ));

        adapter.setTrips(list);
    }
}