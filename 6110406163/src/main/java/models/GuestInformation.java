package models;

public class GuestInformation {
    private String name;
    private String room;
    private String floor;
    private String building;
    private String type;

    public GuestInformation(String name, String room, String floor) {
        this.name = name;
        this.room = room;
        this.floor = floor;
        this.building = "1";
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString(){
        return getName() + " " + getRoom() + " " + getFloor() + " " + getBuilding() + " " + getType();
    }
}
