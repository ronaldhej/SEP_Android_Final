package com.github.sep_android_app.data.model;

public class Room {
    private String name;
    private float temperature, humidity, CO2;

    public Room(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getCO2() {
        return CO2;
    }

    public void setCO2(float CO2) {
        this.CO2 = CO2;
    }

}
