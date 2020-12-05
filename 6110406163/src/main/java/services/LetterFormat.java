package services;

import models.Letter;

import java.util.ArrayList;

public class LetterFormat implements Format{

    @Override
    public ArrayList<Letter> getList(ArrayList<Letter> lists) {
        ArrayList<Letter> tmpList = new ArrayList<>();
        for (Letter e : lists) {
            if(e.getClassName().equals("Letter")){
                tmpList.add(e);
            }
        }
        return tmpList;
    }
}
