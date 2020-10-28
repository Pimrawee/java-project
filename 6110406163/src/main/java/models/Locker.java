package models;

import java.util.ArrayList;

public class Locker {
    private ArrayList<Letter> lockerL;
    private ArrayList<Document> lockerD;
    private ArrayList<Parcel> lockerP;

    public Locker() {
        lockerL = new ArrayList<>();
        lockerD = new ArrayList<>();
        lockerP = new ArrayList<>();
    }

    public void addLetter(Letter letter){
        lockerL.add(letter);
    }

    public void addDocument(Document document){
        lockerD.add(document);
    }

    public void addParcel(Parcel parcel){
        lockerP.add(parcel);
    }

    public void removeLetter(Letter letter){
        lockerL.remove(letter);
    }

    public void removeDocument(Document document){
        lockerD.remove(document);
    }

    public void removeParcel(Parcel parcel){
        lockerP.remove(parcel);
    }

    public ArrayList<Letter> toListLetter() {
        return lockerL;
    }

    public ArrayList<Document> toListDocument() {
        return lockerD;
    }

    public ArrayList<Parcel> toListParcel() {
        return lockerP;
    }
}
