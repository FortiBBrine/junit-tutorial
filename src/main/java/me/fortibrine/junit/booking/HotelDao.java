package me.fortibrine.junit.booking;

import java.util.Arrays;
import java.util.List;

public class HotelDao {

    private final List<Room> cachedRooms = Arrays.asList(

    );

    public List<String> fetchAvailableRooms() {
        return cachedRooms.stream()
                .filter(room -> !room.isAvailable())
                .map(Room::getName)
                .toList();
    }

}
