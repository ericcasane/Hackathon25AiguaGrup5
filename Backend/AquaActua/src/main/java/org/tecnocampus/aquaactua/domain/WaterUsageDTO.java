package org.tecnocampus.aquaactua.domain;

import java.time.LocalDateTime;

public class WaterUsageDTO {
    private String id;
    private String userId;
    private double amountLiters;
    private LocalDateTime timestamp;

    public WaterUsageDTO() {
    }

    public WaterUsageDTO(String id, String userId, double amountLiters, LocalDateTime timestamp) {
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
