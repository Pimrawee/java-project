package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Letter {
    private String type;
    private String time;
    private String receiver;
    private String roomReceiver;
    private String sender;
    private String size;

    public Letter(String receiver, String roomReceiver, String sender, String size) {
        this.type = "Letter";
        this.receiver = receiver;
        this.roomReceiver = roomReceiver;
        this.sender = sender;
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getRoomReceiver() {
        return roomReceiver;
    }

    public String getSender() {
        return sender;
    }

    public String getSize() {
        return size;
    }

    public void setDateTimeReceive(){
        String receiver = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
        this.time = receiver;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setRoomReceiver(String roomReceiver) {
        this.roomReceiver = roomReceiver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getClassName(){
        return "Letter";
    }

    public String getFormat(){
        String line = getType() + ","
                + getTime() + ","
                + getReceiver() + ","
                + getRoomReceiver() + ","
                + getSender() + ","
                + getSize();
        return line;
    }

    @Override
    public String toString() {
        return getReceiver() + " " + getSender() + " " + getSize();
    }
}
