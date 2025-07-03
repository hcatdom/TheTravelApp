package com.hcatdom.travelsocialapp;

import java.io.Serializable;

/**
 * Modelo que representa un viaje en la app.
 */
public class Trip implements Serializable {

    private String id;
    private String title;
    private String description;
    private int imageResId;
    private String location;
    private long timestamp;
    private String userId;

    public Trip() { }

    /**
     * Constructor completo.
     *
     * @param id          ID único (puede ser null antes de guardar)
     * @param title       Título
     * @param description Descripción
     * @param imageResId    URL de la imagen destacada
     * @param location    Ubicación
     * @param timestamp   Marca temporal en milisegundos
     * @param userId      Autor
     */
    public Trip(String id,
                String title,
                String description,
                int imageResId,
                String location,
                long timestamp,
                String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.location = location;
        this.timestamp = timestamp;
        this.userId = userId;
    }

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

    public int getImageResId() {
        return imageResId;
    }
    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
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
                ", imageUrl='" + imageResId + '\'' +
                ", location='" + location + '\'' +
                ", timestamp=" + timestamp +
                ", userId='" + userId + '\'' +
                '}';
    }
}
