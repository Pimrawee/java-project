package models;

import javafx.fxml.FXML;

public class RoomInformation {
    private int room;
    private int floor;
    private String building;
    private int maxGuests;
    private int numGuests;
    private String type;

    public RoomInformation(int room, int floor, String type) {
        this.room = room;
        this.floor = floor;
        this.building = "1";
        this.type = type;
    }

    public int getRoom() {
        return room;
    }

    public int getFloor() {
        return floor;
    }

    public String getBuilding() {
        return building;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public String getType() {
        return type;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return getRoom() + " " + getFloor() + " " + getBuilding() + " "
                + getType() + " " + getMaxGuests() + getNumGuests();
    }
}
