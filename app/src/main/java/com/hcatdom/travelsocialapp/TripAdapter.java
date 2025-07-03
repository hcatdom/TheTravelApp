package com.hcatdom.travelsocialapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hcatdom.travelsocialapp.R;
import com.hcatdom.travelsocialapp.Trip;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter para mostrar una lista de viajes con ubicación y manejo de clicks en la imagen.
 */
public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    /** Interfaz para escuchar clicks en la imagen del viaje */
    public interface OnTripClickListener {
        void onTripImageClick(Trip trip);
    }

    private final List<Trip> trips = new ArrayList<>();
    private final OnTripClickListener listener;

    /**
     * @param listener Callback para clicks en la imagen
     */
    public TripAdapter(OnTripClickListener listener) {
        this.listener = listener;
    }

    /** Reemplaza la lista de viajes y refresca la vista */
    public void setTrips(@NonNull List<Trip> newTrips) {
        trips.clear();
        trips.addAll(newTrips);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trip, parent, false);
        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip trip = trips.get(position);
        holder.tvTitle.setText(trip.getTitle());
        holder.tvLocation.setText(trip.getLocation());
        holder.tvDescription.setText(trip.getDescription());

        // Descargar imagen sin dependencias externas
        new ImageLoadTask(holder.imgTrip).execute(trip.getImageUrl());

        // Asignar callback al click sobre la imagen
        holder.imgTrip.setOnClickListener(v -> listener.onTripImageClick(trip));
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    /** ViewHolder que contiene vistas de cada item */
    static class TripViewHolder extends RecyclerView.ViewHolder {
        final ImageView imgTrip;
        final TextView tvTitle;
        final TextView tvLocation;
        final TextView tvDescription;

        TripViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTrip = itemView.findViewById(R.id.imgTrip);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }

    /**
     * Tarea asíncrona para descargar una imagen desde una URL y asignarla
     */
    private static class ImageLoadTask extends AsyncTask<String, Void, Bitmap> {
        private final ImageView imageView;

        ImageLoadTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urlString = urls[0];
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.connect();
                try (InputStream is = conn.getInputStream()) {
                    return BitmapFactory.decodeStream(is);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                // Recurso de error del sistema
                imageView.setImageResource(android.R.drawable.stat_notify_error);
            }
        }
    }
}