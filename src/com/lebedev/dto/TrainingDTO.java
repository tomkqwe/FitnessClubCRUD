package com.lebedev.dto;

public class TrainingDTO {
    private int id;
    private int coachId;
    private int sportId;
    private int clientId;
    private double price;
    private int scheduleId;

    public TrainingDTO(int id, int coachId, int sportId, int clientId, double price, int scheduleId) {
        this.id = id;
        this.coachId = coachId;
        this.sportId = sportId;
        this.clientId = clientId;
        this.price = price;
        this.scheduleId = scheduleId;
    }

    public TrainingDTO(int coachId, int sportId, int clientId, double price, int scheduleId) {
        this.coachId = coachId;
        this.sportId = sportId;
        this.clientId = clientId;
        this.price = price;
        this.scheduleId = scheduleId;
    }

    @Override
    public String toString() {
        return "TrainingDTO{" +
               "id=" + id +
               ", coachId=" + coachId +
               ", sportId=" + sportId +
               ", clientId=" + clientId +
               ", price=" + price +
               ", scheduleId=" + scheduleId +
               '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
}
