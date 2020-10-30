package models;

import java.util.ArrayList;

public class Rooms {
    private ArrayList<RoomInformation> rooms;

    public Rooms() {
        rooms = new ArrayList<>();
    }

    public void add(RoomInformation roomInformation){
        rooms.add(roomInformation);
    }

    public boolean checkEmpty(){
        if (rooms.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean checkRoom(String room, String floor){ // เช็คว่ามีการเซ็ตห้องไปแล้วหรือยัง
        for (RoomInformation r : rooms){
            if (r.getRoom().equals(room) && r.getFloor().equals(floor)) { // มีเลขห้องกับเลขชั้นที่เซ็ตไว้แล้ว
                return false;
            }
        }
        return true;
    }

    public boolean checkNumGuest(String room, String floor){ // เช็คว่ามีคนพักอยู่ในห้องไหม
        for (RoomInformation r : rooms){
            if (r.getRoom().equals(room) && r.getFloor().equals(floor)){
                if (r.getNumGuests() >= 0 && r.getNumGuests() < r.getMaxGuests()){
                    return true;
                }
            }
        }
        return false;
    }

    public String findTypeRoom(String room, String floor){
        for (RoomInformation r : rooms){
            if (r.getRoom().equals(room) && r.getFloor().equals(floor)){
                return r.getType();
            }
        }
        return "";
    }

    public void addGuest(String room, String floor){
        for (RoomInformation r : rooms){
            if (r.getRoom().equals(room) && r.getFloor().equals(floor)){
                r.setNumGuests(r.getNumGuests()+1);
            }
        }
    }

    public void removeGuest(GuestInformation guestInformation){
        for (RoomInformation r : rooms){
            if (guestInformation.getRoomGuestCon().equals(r.getRoomCon())){
                r.setNumGuests(r.getNumGuests()-1);
            }
        }
    }

    public String roomSet(){
        for (RoomInformation r : rooms) {
            if (r.getNumGuests() >= 0 || r.getNumGuests() < r.getMaxGuests()) {
                return r.getRoomCon();
            }
        }
        return "";
    }

    public ArrayList<RoomInformation> toList() {
        return rooms;
    }

    @Override
    public String toString() {
        String str = "";
        for (RoomInformation r : rooms){
            str += r.toString() + "\n";
        }
        return str;
    }
}
