package com.hcatdom.travelsocialapp;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import io.getstream.photoview.OnMatrixChangedListener;
import io.getstream.photoview.PhotoView;

public class MapFragment extends Fragment {

    public MapFragment() {
        // Constructor vacío requerido
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflar el layout del fragmento
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Aquí ya tienes acceso a la vista inflada
        PhotoView photoView = view.findViewById(R.id.photoView);
        ImageView pin1 = view.findViewById(R.id.pin1);
        ImageView pin2 = view.findViewById(R.id.pin2);
        ImageView pin3 = view.findViewById(R.id.pin3);
        ImageView pin4 = view.findViewById(R.id.pin4);

        // Coordenadas del pin en la imagen original (por ejemplo, 3000x2000 px)
        final float originalX1 = 1500f;
        final float originalY1 = 800f;
        final float originalX2 = 2350f;
        final float originalY2 = 1800f;
        final float originalX3 = 5450f;
        final float originalY3 = 3600f;
        final float originalX4 = 4700f;
        final float originalY4 = 1600f;

        // Escucha los cambios de zoom y movimiento
        photoView.setOnMatrixChangeListener(new OnMatrixChangedListener() {
            @Override
            public void onMatrixChanged(RectF rect) {
                Matrix matrix = photoView.getImageMatrix();
                float[] matrixValues = new float[9];
                matrix.getValues(matrixValues);

                float scale = matrixValues[Matrix.MSCALE_X];
                float transX = matrixValues[Matrix.MTRANS_X];
                float transY = matrixValues[Matrix.MTRANS_Y];

                // Calcula posición del pin en pantalla
                float pinX1 = originalX1 * scale + transX;
                float pinY1 = originalY1 * scale + transY;
                float pinX2 = originalX2 * scale + transX;
                float pinY2 = originalY2 * scale + transY;
                float pinX3 = originalX3 * scale + transX;
                float pinY3 = originalY3 * scale + transY;
                float pinX4 = originalX4 * scale + transX;
                float pinY4 = originalY4 * scale + transY;

                // Coloca el pin (centrado)
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
    }
}
