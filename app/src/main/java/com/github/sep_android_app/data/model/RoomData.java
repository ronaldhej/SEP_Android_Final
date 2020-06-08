package com.github.sep_android_app.data.model;

public class RoomData {
    private String date;
    private String room;
    private int temperature;
    private int humidity;
    private int co2;

    public RoomData(String room, String date, int temperature, int humidity, int co2) {
        this.date = date;
        this.room = room;
        this.temperature = temperature;
        this.humidity = humidity;
        this.co2 = co2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }
}
