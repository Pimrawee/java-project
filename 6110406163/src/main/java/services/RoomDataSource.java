package services;

import models.Rooms;

public interface RoomDataSource {
    Rooms getRoomsData();

    void setRoomsData(Rooms rooms);
}
