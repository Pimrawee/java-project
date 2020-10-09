package models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StaffInformation {//implements Comparable<StaffInformation>{
    private String name;
    private String username;
    private String password;
    private int dayLogin;
    private int monthLogin;
    private int yearLogin;
    private int hourLogin;
    private int minuteLogin;

    public StaffInformation(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getDayLogin() {
        return dayLogin;
    }

    public int getMonthLogin() {
        return monthLogin;
    }

    public int getYearLogin() {
        return yearLogin;
    }

    public int getHourLogin() {
        return hourLogin;
    }

    public int getMinuteLogin() {
        return minuteLogin;
    }

    public String getDate(){
        return dayLogin + "/" + monthLogin + "/" + yearLogin;
    }

    public String getTime(){
        return hourLogin + ":" + minuteLogin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateTimeLogin(){
        Calendar calendar = new GregorianCalendar();
        this.dayLogin = calendar.get(Calendar.DATE);
        this.monthLogin = calendar.get(Calendar.MONTH)+1;
        this.yearLogin = calendar.get(Calendar.YEAR);
        this.hourLogin = calendar.get(Calendar.HOUR_OF_DAY);
        this.minuteLogin = calendar.get(Calendar.MINUTE);

    }

    @Override
    public String toString() {
        return getDate() + " " + getTime() + " " + getName() + " " + getUsername() + " " + getPassword();
    }

//    @Override
//    public int compareTo(StaffInformation o) {
//        if (this.getDateLogin() > o.getDateLogin()) return 1;
//
//        return 0;
//    }
}
