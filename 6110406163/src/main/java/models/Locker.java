package models;

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

    public ArrayList<Letter> toListLetter() {
        ArrayList<Letter> letters = new ArrayList<>();
        for (Letter e : lockers) {
            if(e.getClassName().equals("Letter")){
                letters.add(e);
            }
        }
        return letters;
    }

    public ArrayList<Document> toListDocument() {
        ArrayList<Document> letters = new ArrayList<>();
        for (Letter e : lockers) {
            if(e.getClassName().equals("Document")){
                letters.add((Document) e);
            }
        }
        return letters;
    }

    public ArrayList<Parcel> toListParcel() {
        ArrayList<Parcel> letters = new ArrayList<>();
        for (Letter e : lockers) {
            if(e.getClassName().equals("Parcel")){
                letters.add((Parcel) e);
            }
        }
        return letters;
    }
}