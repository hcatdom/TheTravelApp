package com.hcatdom.travelsocialapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hcatdom.travelsocialapp.databinding.FragmentAddTripBinding;

public class AddTripFragment extends Fragment {

    private FragmentAddTripBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddTripBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    //Creamos los botones y los mensajes que muestran tras el Click
    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.selectLocationButton.setOnClickListener(v ->
                Toast.makeText(getContext(), "Seleccionar ubicación", Toast.LENGTH_SHORT).show()
        );

        binding.selectMediaButton.setOnClickListener(v ->
                Toast.makeText(getContext(), "Seleccionar fotos/videos", Toast.LENGTH_SHORT).show()
        );

        binding.saveTripButton.setOnClickListener(v -> {
            String title = binding.tripTitleEditText.getText().toString().trim();
            String desc  = binding.tripDescriptionEditText.getText().toString().trim();
            Toast.makeText(getContext(),
                    "Guardando viaje:\n" + title + "\n" + desc,
                    Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
