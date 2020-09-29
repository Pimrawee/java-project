package models;

import java.util.ArrayList;

public class Locker {
    private ArrayList<Object> locker;

    public Locker() {
        locker = new ArrayList<>();
    }

    public void addObject(Object object){
        locker.add(object);
    }

    public void removeObject(Object object){
        locker.remove(object);
    }

    @Override
    public String toString() {
        String str = "";
        for (Object o : locker){
            str += o.toString() + "\n";
        }
        return str;
    }
}
