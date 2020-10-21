package models;

public class GuestInformation {
    private String name;
    private String building;
    private String floor;
    private String room;
    private String type;
    private String roomGuestCon;

    public GuestInformation(String name, String room, String floor) {
        this.name = name;
        this.room = room;
        this.floor = floor;
        this.building = "1";
    }

    public String getName() {
        return name;
    }

    public String getBuilding() {
        return building;
    }

    public String getFloor() {
        return floor;
    }

    public String getRoom() {
        return room;
    }

    public String getType() {
        return type;
    }

    public String getRoomGuestCon() {
        return roomGuestCon = building + floor + room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoomGuestCon(String roomGuestCon) {
        this.roomGuestCon = roomGuestCon;
    }

    @Override
    public String toString(){
        return getName() + " " + getRoom() + " " + getFloor() + " " + getBuilding() + " " + getType();
    }
}
