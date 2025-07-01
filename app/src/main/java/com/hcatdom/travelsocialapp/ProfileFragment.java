package com.hcatdom.travelsocialapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hcatdom.travelsocialapp.databinding.FragmentProfileBinding;
import com.hcatdom.travelsocialapp.AddTripFragment;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

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

        // Botón "Ver mis viajes"
        binding.viewTripsButton.setOnClickListener(v ->
                Toast.makeText(getContext(), "Ver mis viajes pulsado", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
