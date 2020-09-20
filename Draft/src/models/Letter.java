package models;

public class Letter {
    private String receiver;
    private String sender;
    private int size;

    public Letter(String receiver, String sender, int size) {
        this.receiver = receiver;
        this.sender = sender;
        this.size = size;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

    public int getSize() {
        return size;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
