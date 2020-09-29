package models;

public class Letter {
    private String receiver;
    private String sender;
    private String size;

    public Letter(String receiver, String sender, String size) {
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

    public String getSize() {
        return size;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return getReceiver() + " " + getSender() + " " + getSize();
    }
}
