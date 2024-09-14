package me.fortibrine.junit.test.booking;

import me.fortibrine.junit.booking.BookingManager;
import me.fortibrine.junit.booking.HotelDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookingManagerTest {

    private HotelDao hotelDaoMock;
    private BookingManager bookingManager;

    @BeforeEach
    public void setUp() {
        hotelDaoMock = Mockito.mock(HotelDao.class);
        bookingManager = new BookingManager(hotelDaoMock);

        List<String> availableRooms = List.of("A");
        Mockito.when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

    }

    @Test
    public void checkAvailableRoomsTrue() {
        assertTrue(bookingManager.checkRoomAvailability("A"));
    }

    @Test
    public void checkAvailableRoomsFalse() {
        List<String> availableRooms = List.of("A");
        Mockito.when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

        assertFalse(bookingManager.checkRoomAvailability("B"));
    }

}
