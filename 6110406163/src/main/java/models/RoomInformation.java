package models;

public class RoomInformation {
    private String room;
    private String floor;
    private String building;
    private int maxGuests;
    private int numGuests;
    private String type;
    private String roomCon;

    public RoomInformation(String room, String floor, String type) {
        this.room = room;
        this.floor = floor;
        this.building = "1";
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

    public int getMaxGuests() {
        return maxGuests;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public String getType() {
        return type;
    }

    public String getRoomCon() {
        return roomCon = getBuilding() + getFloor() + getRoom();
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

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoomCon(String roomCon) {
        this.roomCon = roomCon;
    }

    @Override
    public String toString(){
        return getRoom() + " " + getFloor() + " " + getBuilding() + " "
                + getType() + " " + getMaxGuests() + " " + getNumGuests();
    }
}
