package org.example.entity;

public class Earthquake {
    private String id;
    private int time;
    private String place;
    private double latitude;
    private double longitude;
    private double depth;
    private double magnitude;

    public Earthquake(String id, int time, String place, double latitude, double longitude, double depth, double magnitude) {
        this.id = id;
        this.time = time;
        this.place = place;
        this.latitude = latitude;
        this.longitude = longitude;
        this.depth = depth;
        this.magnitude = magnitude;
    }

    // Getters ve toString metodu
    public String getPlace() {
        return place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("Magnitude %.2f at %s", magnitude, place);
    }
}