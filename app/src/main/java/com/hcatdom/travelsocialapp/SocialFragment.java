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

import com.hcatdom.travelsocialapp.databinding.FragmentSocialBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SocialFragment extends Fragment {
    private FragmentSocialBinding binding;
    private TripAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSocialBinding.inflate(inflater, container, false);

        // Configurar RecyclerView
        RecyclerView rvTrips = binding.rvTrips;
        rvTrips.setLayoutManager(new LinearLayoutManager(getContext()));

        // 1) Cargar la lista de viajes
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

        // 2) Crear el adapter pasándole la lista y el listener para clicks en la imagen
        adapter = new TripAdapter(list, trip -> {
            Intent intent = new Intent(getContext(), DetallesViaje.class);
            intent.putExtra(DetallesViaje.EXTRA_TRIP, (Serializable) trip);
            startActivity(intent);
        });

        // 3) Asociar el adapter al RecyclerView
        rvTrips.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}