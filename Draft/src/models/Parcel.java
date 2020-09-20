package models;

public class Parcel extends Letter{
    private String receiver;
    private String sender;
    private int size;
    private String company;
    private String trackingNumber;

    public Parcel(String receiver, String sender, int size, String company, String trackingNumber) {
        super(receiver, sender, size);
        this.company = company;
        this.trackingNumber = trackingNumber;
    }

    public String getCompany() {
        return company;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
