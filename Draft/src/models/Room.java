package models;

public class Room {
    private String room;
    private String floor;
    private String building;
    private String type;

    public Room(String room, String floor, String building, String type) {
        this.room = room;
        this.floor = floor;
        this.building = building;
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public String getFloor() {
        return floor;
    }

    public String getBuilding() {
        return building;
    }

    public String getType() {
        return type;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setType(String type) {
        this.type = type;
    }
}
