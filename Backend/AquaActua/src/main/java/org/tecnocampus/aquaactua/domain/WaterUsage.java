package org.tecnocampus.aquaactua.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class WaterUsage {

    @Id
    private String id;

    private String userId;
    private double amountLiters;
    private LocalDateTime timestamp;

    public WaterUsage() {
    }

    public WaterUsage(String id, String userId, double amountLiters, LocalDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.amountLiters = amountLiters;
        this.timestamp = timestamp;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmountLiters() {
        return amountLiters;
    }

    public void setAmountLiters(double amountLiters) {
        this.amountLiters = amountLiters;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
