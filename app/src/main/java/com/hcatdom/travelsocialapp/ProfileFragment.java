package com.hcatdom.travelsocialapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcatdom.travelsocialapp.databinding.FragmentProfileBinding;
import com.hcatdom.travelsocialapp.AddTripFragment;
import com.hcatdom.travelsocialapp.databinding.FragmentSocialBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private TripAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Botón "Añadir viaje"
        binding.addTripButton.setOnClickListener(v ->{
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new AddTripFragment())
                    .addToBackStack(null)
                    .commit();
    });

        RecyclerView rvTrips = binding.rvTrips;
        rvTrips.setLayoutManager(new LinearLayoutManager(getContext()));

        // 1) Cargar la lista de viajes
        List<Trip> list = new ArrayList<>();
        list.add(new Trip(
                "4",
                "Viaje al bosque negro",
                "Paseíllo mañanero con mi amigo Sam (que va lentín) por el bosque negro.",
                R.drawable.frodoviaje,
                "Bosque Negro",
                System.currentTimeMillis(),
                "seniorfrodoomg"
        ));;

        // 2) Crear el adapter pasándole la lista y el listener para clicks en la imagen
        adapter = new TripAdapter(list, trip -> {
            Intent intent = new Intent(getContext(), DetallesViaje.class);
            intent.putExtra(DetallesViaje.EXTRA_TRIP, (Serializable) trip);
            startActivity(intent);
        });

        // 3) Asociar el adapter al RecyclerView
        rvTrips.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
