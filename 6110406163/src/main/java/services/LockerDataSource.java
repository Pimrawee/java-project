package services;


import models.Locker;

public interface LockerDataSource {
    Locker getLockerData();

    void setLockerData(Locker locker);
}
