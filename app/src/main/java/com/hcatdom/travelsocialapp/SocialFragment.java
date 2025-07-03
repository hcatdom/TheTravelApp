package com.hcatdom.travelsocialapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcatdom.travelsocialapp.R;
import com.hcatdom.travelsocialapp.TripAdapter;
import com.hcatdom.travelsocialapp.Trip;

import java.util.ArrayList;
import java.util.List;

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

import java.util.ArrayList;
import java.util.List;

public class SocialFragment extends Fragment {
    private RecyclerView rvTrips;
    private TripAdapter adapter;

    public SocialFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_social, container, false);

        rvTrips = root.findViewById(R.id.rvTrips);
        rvTrips.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TripAdapter();
        rvTrips.setAdapter(adapter);
        loadLocalTrips();

        return root;
    }

    /**
     * Carga una lista de viajes de ejemplo directamente en memoria.
     * Sustituye esta implementación por una fuente real (REST, BD local, etc.) cuando lo necesites.
     */
    /**
     * Carga 10 viajes predeterminados directamente en memoria.
     */
    private void loadLocalTrips() {
        List<Trip> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new Trip(
                    String.valueOf(i),
                    "Viaje predeterminado " + i,
                    "Descripción del viaje número " + i + ". Disfruta de una experiencia única.",
                    "https://example.com/images/trip" + i + ".jpg",
                    System.currentTimeMillis() + i * 1000,
                    "user" + (100 + i)
            ));
        }
        adapter.setTrips(list);
    }

}
