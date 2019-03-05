package com.weather.coolest.day.model;


// Model class to store coolest hour and temperature

public class Temperature {

    private float temperature;
    private int hour;

    public Temperature() {
    }

    public Temperature(float temperature, int hour) {
        this.temperature = temperature;
        this.hour = hour;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
