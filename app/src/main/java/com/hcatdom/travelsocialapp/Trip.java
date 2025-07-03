package com.hcatdom.travelsocialapp;

/**
 * Modelo que representa un viaje publicado en la red social.
 */
public class Trip {

    private String id;           // ID del documento en Firestore
    private String title;        // Título del viaje
    private String description;  // Descripción corta
    private String imageUrl;     // URL de la foto del viaje
    private long timestamp;      // Fecha de creación en milisegundos
    private String userId;       // ID del usuario que publica

    /** Constructor vacío obligatorio para Firebase (o librerías de mapeo). */
    public Trip() { }

    /**
     * Constructor completo.
     *
     * @param id          ID
     * @param title       Título del viaje
     * @param description Descripción del viaje
     * @param imageUrl    link de la imagen
     * @param timestamp   Tiempo (en ms)
     * @param userId      Id del Autor
     */
    public Trip(String id, String title, String description,
                String imageUrl, long timestamp, String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    // Getters y setters

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
                ", timestamp=" + timestamp +
                ", userId='" + userId + '\'' +
                '}';
    }
}