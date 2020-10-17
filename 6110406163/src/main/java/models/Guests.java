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
