package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StaffInformation{
    private String name;
    private String username;
    private String password;
    private String date;

    public StaffInformation(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.date = "";
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

    public String getDate() {
        return date;
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

    public void setDate(String date) {
        this.date = date;
    }

    public void setDateTimeLogin(){
        String login = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
        this.date = login;
    }

    @Override
    public String toString() {
        return getDate() + " " + getName() + " " + getUsername() + " " + getPassword();
    }
}
