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

    public boolean checkRoom(int room, int floor){ // เช็คว่ามีการเซ็ตห้องไปแล้วรือยัง
        for (RoomInformation r : rooms){
            if (r.getRoom() == room && r.getFloor() == floor) { // มีเลขห้องกับเลขชั้นที่เซ็ตไว้แล้ว
                return false;
            }
        }
        return true;
    }

    public boolean checkNumGuest(int room, int floor){ // เช็คว่ามีคนพักอยู่ในห้องไหม
        for (RoomInformation r : rooms){
            if (r.getRoom() == room && r.getFloor() == floor){
                if (r.getNumGuests() > 0){
                    return true;
                }
            }
        }
        return false;
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
