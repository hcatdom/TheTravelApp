
package com.hcatdom.travelsocialapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.hcatdom.travelsocialapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //el boolean lo creo para cuando apretamos el botón en la pestaña de DetallesViaje. Si no, tbn vamos al Mapa sin pulsar el botón (inicio de la app)
        boolean abrirMapa = getIntent().getBooleanExtra("abrirMapa", false);
        if (abrirMapa) {
            binding.bottomNavigation.setSelectedItemId(R.id.mapFragment);
            loadFragment(new MapFragment());
        } else {
            loadFragment(new MapFragment());
        }

        //Los botones de la parte inferior que hacen que cambiemos de pestañas :)
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.mapFragment) {
                selectedFragment = new MapFragment();
            } else if (itemId == R.id.socialFragment) {
                selectedFragment = new SocialFragment();
            } else if (itemId == R.id.profileFragment) {
                selectedFragment = new ProfileFragment();
            }

            return loadFragment(selectedFragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
