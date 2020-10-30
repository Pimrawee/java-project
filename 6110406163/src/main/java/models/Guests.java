package models;

import java.util.ArrayList;

public class Guests {
    private ArrayList<GuestInformation> guests;

    public Guests(){
        guests = new ArrayList<>();
    }

    public void add(GuestInformation guestInformation){
        guests.add(guestInformation);
    }

    public void remove(GuestInformation guestInformation){
        guests.remove(guestInformation);
    }

    public boolean checkGuest(String nameGuest, String room){
        for (GuestInformation g : guests){
            if (g.getName().equals(nameGuest) && g.getRoomGuestCon().equals(room)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<GuestInformation> toList() {
        return guests;
    }

    @Override
    public String toString() {
        String str = "";
        for (GuestInformation g : guests){
            str += g.toString() + "\n";
        }
        return str;
    }
}
