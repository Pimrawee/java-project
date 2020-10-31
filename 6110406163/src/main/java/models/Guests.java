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

    public void setUsernameAndPassword(String name, String username, String password){
        for (GuestInformation g : guests){
            if (g.getName().equals(name)){
                g.setUsername(username);
                g.setPassword(password);
            }
        }
    }

    public boolean checkUsernameGuest(String username){
        for (GuestInformation g : guests){
            if (g.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public void setNewPassword(String username, String newPassword){
        for (GuestInformation g : guests) {
            if (g.getUsername().equals(username)) {
                g.setPassword(newPassword);
            }
        }
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
