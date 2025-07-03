package com.hcatdom.travelsocialapp;

import java.io.Serializable;

/**
 * Modelo que representa un viaje en la app.
 */
public class Trip implements Serializable {

    private String id;           // ID único del viaje
    private String title;        // Título del viaje
    private String description;  // Descripción del viaje
    private String imageUrl;     // URL de la imagen destacada
    private String location;     // Ubicación (p.ej. "La Comarca")
    private long timestamp;      // Marca temporal en milisegundos
    private String userId;       // ID del usuario que publica

    /**
     * Constructor vacío requerido para mapeo automático (Firebase, JSON, etc.)
     */
    public Trip() { }

    /**
     * Constructor completo.
     *
     * @param id          ID único (puede ser null antes de guardar)
     * @param title       Título del viaje
     * @param description Descripción breve
     * @param imageUrl    URL de la imagen destacada
     * @param location    Ubicación del viaje
     * @param timestamp   Marca temporal en milisegundos
     * @param userId      ID del autor del viaje
     */
    public Trip(String id,
                String title,
                String description,
                String imageUrl,
                String location,
                long timestamp,
                String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.location = location;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", location='" + location + '\'' +
                ", timestamp=" + timestamp +
                ", userId='" + userId + '\'' +
                '}';
    }
}
