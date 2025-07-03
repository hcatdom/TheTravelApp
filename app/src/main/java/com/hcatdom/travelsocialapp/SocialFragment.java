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

        View root = inflater.inflate(R.layout.fragment_social, container, false);

        rvTrips = root.findViewById(R.id.rvTrips);
        rvTrips.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new TripAdapter(trip -> {
            Intent intent = new Intent(getContext(), DetallesViaje.class);
            intent.putExtra(DetallesViaje.EXTRA_TRIP, (Serializable) trip);
            startActivity(intent);
        });
        rvTrips.setAdapter(adapter);

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
                "Montañas Azules",
                System.currentTimeMillis(),
                "enano777"
        ));

        list.add(new Trip(
                "2",
                "Devolviendo la luz a donde se merece :P",
                "Tardeo destruyendo el anillo que los une a todos con los panas.",
                R.drawable.mordor,
                "Mordor",
                System.currentTimeMillis() + 1000,
                "_.._tublancooo_.._"
        ));

        list.add(new Trip(
                "3",
                "Cata de hidromiel en La Comarca",
                "Un disfrute de los brebajes que fermentan los propios hobbits.",
                R.drawable.comarca,
                "La Comarca",
                System.currentTimeMillis() + 2000,
                "enano777"
        ));

        adapter.setTrips(list);
    }
}