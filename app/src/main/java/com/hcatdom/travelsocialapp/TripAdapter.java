package com.hcatdom.travelsocialapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    /** Listener para clicks en la imagen */
    public interface OnTripClickListener {
        void onTripImageClick(Trip trip);
    }

    private final List<Trip> trips;
    private final OnTripClickListener listener;

    public TripAdapter(List<Trip> trips, OnTripClickListener listener) {
        this.trips = trips;
        this.listener = listener;
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

        // Campos siempre visibles
        holder.tvTitle.setText(trip.getTitle());
        holder.tvLocation.setText(trip.getLocation());
        holder.tvDescription.setText(trip.getDescription());
        holder.imgTrip.setImageResource(trip.getImageResId());

        // Click en la imagen abre detalle
        holder.imgTrip.setOnClickListener(v -> listener.onTripImageClick(trip));
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    /** ViewHolder para cada item */
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
}
