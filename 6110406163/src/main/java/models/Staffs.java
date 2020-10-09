package models;

import java.util.ArrayList;

public class Staffs{
    private ArrayList<StaffInformation> staffs;

    public Staffs(){
        staffs = new ArrayList<>();
    }

    public void addStaff(StaffInformation staff){
        staffs.add(staff);
    }

    public boolean checkPinStaff(String username, String password){ // เช็ค username and password ตอนที่ staff login
        for (StaffInformation s : staffs){
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkStaff(String name){
        for (StaffInformation s : staffs) {
            if (s.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEmpty(){
        if (staffs.isEmpty()){
            return true;
        }
        return false;
    }

    public void setDateTime(String username, String password){
        for (StaffInformation s : staffs) {
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                s.setDateTimeLogin();
            }
        }
    }

    public ArrayList<StaffInformation> toList() {
        return staffs;
    }

    @Override
    public String toString() {
        String str = "";
        for (StaffInformation s : staffs){
            str += s.toString() + "\n";
        }
        return str;
    }
}
