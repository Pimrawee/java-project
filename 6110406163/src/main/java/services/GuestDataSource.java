package services;

import models.Guests;

public interface GuestDataSource {
    Guests getGuestsData();

    void setGuestsData(Guests guests);
}
