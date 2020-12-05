package services;

import models.Letter;

import java.util.ArrayList;

public class ParcelFormat implements Format{
    @Override
    public ArrayList<Letter> getList(ArrayList<Letter> lists) {
        ArrayList<Letter> tmpList = new ArrayList<>();
        for (Letter e : lists) {
            if(e.getClassName().equals("Parcel")){
                tmpList.add(e);
            }
        }
        return tmpList;
    }
}