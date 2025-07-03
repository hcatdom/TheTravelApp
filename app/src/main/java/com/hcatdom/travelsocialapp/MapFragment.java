package com.hcatdom.travelsocialapp;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import io.getstream.photoview.OnMatrixChangedListener;
import io.getstream.photoview.PhotoView;

public class MapFragment extends Fragment {

    public MapFragment() {
        // Required empty public constructor
        PhotoView photoView = findViewById(R.id.photoView);
        ImageView pin1 = view.findViewById(R.id.pin1);


// Coordenadas del pin en la imagen original (por ejemplo, 3000x2000)
        final float originalX = 1500f;
        final float originalY = 800f;

// Escucha de cambios de transformación
        photoView.setOnMatrixChangeListener(new OnMatrixChangedListener() {
            @Override
            public void onMatrixChanged(RectF rect) {
                Matrix matrix = photoView.getImageMatrix();
                float[] matrixValues = new float[9];
                matrix.getValues(matrixValues);

                float scale = matrixValues[Matrix.MSCALE_X];
                float transX = matrixValues[Matrix.MTRANS_X];
                float transY = matrixValues[Matrix.MTRANS_Y];

                // Calculamos dónde debería estar el pin en pantalla
                float pinX = originalX * scale + transX;
                float pinY = originalY * scale + transY;

                // Colocamos el pin (ajustando para centrarlo)
                pin1.setX(pinX - pin1.getWidth() / 2f);
                pin1.setY(pinY - pin1.getHeight() / 2f);
            }
        });

//    private <__TMP__> __TMP__ findviewbyid() {
//    }
//
//    private <__TMP__> __TMP__ findviewbyid() {
    }

 }