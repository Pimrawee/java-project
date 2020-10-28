package models;

public class Parcel extends Letter {
    private String company;
    private String trackingNumber;

    public Parcel(String receiver, String roomReceiver, String sender, String size, String company, String trackingNumber) {
        super(receiver, roomReceiver, sender, size);
        super.setType("Parcel");
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

    @Override
    public String toString() {
        return super.toString() + " " + getCompany() + " " + getTrackingNumber();
    }
}
