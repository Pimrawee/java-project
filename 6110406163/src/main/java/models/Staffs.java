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

    public boolean checkStaff(String username, String password){ // เช็ค username and password ตอนที่ staff login
        for (StaffInformation s : staffs){
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
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
