package models;

public class GuestInformation {
    private String name;
    private int room;
    private int floor;
    private String building;
    private String type;

    public GuestInformation(String name, int room, int floor) {
        this.name = name;
        this.room = room;
        this.floor = floor;
        this.building = "1";
    }

    public String getName() {
        return name;
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

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return getName() + " " + getRoom() + " " + getFloor() + " " + getBuilding() + " " + getType();
    }
}
