package com.mockitoCourse.restaurantService;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class BookingManagerTest {

    @Test
    public void addReservationWithMockito(){
        BookingPersister bookingPersisterSpy = spy(BookingPersister.class);
        BookingManager bookingManager = new BookingManager(bookingPersisterSpy);

        //Argument Captor enables to extract Object passed into a method call
        ArgumentCaptor<Booking> captureBooking = ArgumentCaptor.forClass(Booking.class);
        bookingManager.addReservation("Pedro", 2, 19);

        verify(bookingPersisterSpy).persistToDatabase(captureBooking.capture());
        Booking captureBookginValue = captureBooking.getValue();

        assertEquals("Pedro", captureBookginValue.getTable().getName());
        assertEquals(2, captureBookginValue.getTable().getNumber());
        assertEquals(19, captureBookginValue.getTable().getTime());
    }

}