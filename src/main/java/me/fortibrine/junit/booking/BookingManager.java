package me.fortibrine.junit.booking;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookingManager {

    private final HotelDao dao;

    public boolean checkRoomAvailability(String roomName) {
        return dao.fetchAvailableRooms().contains(roomName);
    }

}
