package com.hcatdom.travelsocialapp;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.io.Serializable;

import io.getstream.photoview.OnMatrixChangedListener;
import io.getstream.photoview.PhotoView;

public class MapFragment extends Fragment {

    public MapFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PhotoView photoView = view.findViewById(R.id.photoView);
        ImageView pin1 = view.findViewById(R.id.pin1);
        ImageView pin2 = view.findViewById(R.id.pin2);
        ImageView pin3 = view.findViewById(R.id.pin3);
        ImageView pin4 = view.findViewById(R.id.pin4);

        //Localización pines
        final float originalX1 = 1500f;
        final float originalY1 = 800f;
        final float originalX2 = 2350f;
        final float originalY2 = 1800f;
        final float originalX3 = 5450f;
        final float originalY3 = 3600f;
        final float originalX4 = 4700f;
        final float originalY4 = 1600f;

        photoView.setOnMatrixChangeListener(new OnMatrixChangedListener() {
            @Override
            public void onMatrixChanged(RectF rect) {
                Matrix matrix = photoView.getImageMatrix();
                float[] matrixValues = new float[9];
                matrix.getValues(matrixValues);
                float scale = matrixValues[Matrix.MSCALE_X];
                float transX = matrixValues[Matrix.MTRANS_X];
                float transY = matrixValues[Matrix.MTRANS_Y];

                //escalas pines
                float pinX1 = originalX1 * scale + transX;
                float pinY1 = originalY1 * scale + transY;
                float pinX2 = originalX2 * scale + transX;
                float pinY2 = originalY2 * scale + transY;
                float pinX3 = originalX3 * scale + transX;
                float pinY3 = originalY3 * scale + transY;
                float pinX4 = originalX4 * scale + transX;
                float pinY4 = originalY4 * scale + transY;

                //centrar y asignar posicion de pines
                pin1.setX(pinX1 - pin1.getWidth() / 2f);
                pin1.setY(pinY1 - pin1.getHeight());
                pin2.setX(pinX2 - pin2.getWidth() / 2f);
                pin2.setY(pinY2 - pin2.getHeight());
                pin3.setX(pinX3 - pin3.getWidth() / 2f);
                pin3.setY(pinY3 - pin3.getHeight());
                pin4.setX(pinX4 - pin4.getWidth() / 2f);
                pin4.setY(pinY4 - pin4.getHeight());
            }
        });

        //Viaje gimli 1
        pin1.setOnClickListener(v -> {
            Trip trip1=new Trip(
                    "1",
                    "Viaje de aventura a las montañas azules",
                    "Vacaciones a base de rutitas visitando los parajes del norte.",
                    R.drawable.bluemountains,
                    "Montañas Azules",
                    System.currentTimeMillis(),
                    "enano777"
            );
            View popupView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_popup, null);
            //salta el mensajito en el mapa junto al botoncito
            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    true
            );
            TextView popupTitle = popupView.findViewById(R.id.popupTitle);
            Button btnVerDetalles = popupView.findViewById(R.id.btnVerViaje);
            popupTitle.setText("enano777 ha ido a Ered Luin");
            //el boton nos lleva a DetallesViaje
            btnVerDetalles.setOnClickListener(btn -> {
                Intent intent = new Intent(getContext(), DetallesViaje.class);
                intent.putExtra(DetallesViaje.EXTRA_TRIP, (Serializable) trip1);
                startActivity(intent);
            });
            int offsetX = 0;
            int offsetY = -pin1.getHeight() - 20;
            popupWindow.setElevation(10f);
            popupWindow.showAsDropDown(pin1, offsetX, offsetY);
        });

        //Viaje gimli 2
        pin2.setOnClickListener(v -> {
            Trip trip3 = new Trip(
                    "3",
                    "Cata de hidromiel en La Comarca",
                    "Un disfrute de los brebajes que fermentan los propios hobbits.",
                    R.drawable.comarca,
                    "La Comarca",
                    System.currentTimeMillis() + 2000,
                    "enano777"
            );
            View popupView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_popup, null);
            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    true
            );
            TextView popupTitle = popupView.findViewById(R.id.popupTitle);
            Button btnVerDetalles = popupView.findViewById(R.id.btnVerViaje);
            popupTitle.setText("enano777 ha ido a La Comarca con orlando_bloom_fans");
            btnVerDetalles.setOnClickListener(btn -> {
                Intent intent = new Intent(getContext(), DetallesViaje.class);
                intent.putExtra(DetallesViaje.EXTRA_TRIP, (Serializable) trip3);
                startActivity(intent);
            });
            int offsetX = 0;
            int offsetY = -pin2.getHeight() - 20;
            popupWindow.setElevation(10f);
            popupWindow.showAsDropDown(pin2, offsetX, offsetY);
        });

        //Viaje gandalf
        pin3.setOnClickListener(v -> {
            Trip trip2 = new Trip(
                    "2",
                    "Devolviendo la luz a donde se merece :P",
                    "Tardeo destruyendo el anillo que los une a todos con los panas.",
                    R.drawable.mordor,
                    "Mordor",
                    System.currentTimeMillis() + 1000,
                    "_.._tublancooo_.._"
            );
            View popupView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_popup, null);
            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    true
            );
            TextView popupTitle = popupView.findViewById(R.id.popupTitle);
            Button btnVerDetalles = popupView.findViewById(R.id.btnVerViaje);
            popupTitle.setText("_.._tublancooo_.._ ha ido a La Torre de Sauron, en Mordor");
            btnVerDetalles.setOnClickListener(btn -> {
                Intent intent = new Intent(getContext(), DetallesViaje.class);
                intent.putExtra(DetallesViaje.EXTRA_TRIP, (Serializable) trip2);
                startActivity(intent);
            });
            int offsetX = 0;
            int offsetY = -pin3.getHeight() - 20;
            popupWindow.setElevation(10f);
            popupWindow.showAsDropDown(pin3, offsetX, offsetY);
        });

        //Viaje usuario
        pin4.setOnClickListener(v -> {
            Trip trip4=new Trip(
                    "4",
                    "Viaje al bosque negro",
                    "Paseíllo mañanero con mi amigo Sam (que va lentín) por el bosque negro.",
                    R.drawable.frodoviaje,
                    "Bosque Negro",
                    System.currentTimeMillis(),
                    "seniorfrodoomg"
            );
            View popupView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_popup, null);
            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    true
            );
            TextView popupTitle = popupView.findViewById(R.id.popupTitle);
            Button btnVerDetalles = popupView.findViewById(R.id.btnVerViaje);
            popupTitle.setText("Has ido al Bosque Negro");
            btnVerDetalles.setOnClickListener(btn -> {
                Intent intent = new Intent(getContext(), DetallesViaje.class);
                intent.putExtra(DetallesViaje.EXTRA_TRIP, (Serializable) trip4);
                startActivity(intent);
            });
            int offsetX = 0;
            int offsetY = -pin4.getHeight() - 20;
            popupWindow.setElevation(10f);
            popupWindow.showAsDropDown(pin4, offsetX, offsetY);
        });

    }

}