package com.github.sep_android_app.data.model;

public class Alert {
    private String alert;
    private String room;

    public Alert(String alert, String room) {
        this.alert = alert;
        this.room = room;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
