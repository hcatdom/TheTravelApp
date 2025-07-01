package com.hcatdom.travelsocialapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.hcatdom.travelsocialapp.R;

import com.hcatdom.travelsocialapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //ACTIVA EL MAPA
        loadFragment(new MapFragment());

        binding.bottomNavigation.setOnItemSelectedListener((android.view.MenuItem item) -> {
            Fragment selectedFragment = null;

            int itemId = item.getItemId();

            if (itemId == R.id.mapFragment) {
                selectedFragment = new MapFragment();
            } else if (itemId == R.id.socialFragment) {
                selectedFragment = new SocialFragment();
            } else if (itemId == R.id.profileFragment) {
                selectedFragment = new ProfileFragment();
            }
//            switch (item.getItemId()) {
//                case R.id.mapFragment:
//                    selectedFragment = new MapFragment();
//                    break;
//                case R.id.socialFragment:
//                    selectedFragment = new SocialFragment();
//                    break;
//                case R.id.profileFragment:
//                    selectedFragment = new ProfileFragment();
//                    break;
//            }
            return loadFragment(selectedFragment);
        });

    }

    //CAMBIAR DE MENÚ
    private boolean loadFragment(Fragment fragment) {
        if (fragment!=null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
