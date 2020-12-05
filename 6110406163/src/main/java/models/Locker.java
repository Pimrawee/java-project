package models;

import services.Format;

import java.util.ArrayList;

public class Locker {
    private ArrayList<Letter> lockers;

    public Locker() {
        lockers = new ArrayList<>();
    }

    public void addItem(Letter letter){
        lockers.add(letter);
    }

    public void removeItem(Letter letter){
        lockers.remove(letter);
    }

    public ArrayList<Letter> getLockers() {
        return lockers;
    }

    public ArrayList<Letter> toLists(Format format) {
        return format.getList(lockers);
    }
}