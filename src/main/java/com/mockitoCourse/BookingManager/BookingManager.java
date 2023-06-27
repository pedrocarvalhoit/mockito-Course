package com.mockitoCourse.BookingManager;


import java.sql.SQLException;
import java.util.List;

//Using Mock
public class BookingManager{

    private HotelDao dao;

    public BookingManager(HotelDao dao){
        this.dao = dao;
    }

    public boolean chekRoomAvailability(String roomName) throws SQLException{
        List<String> roomsAvailable = dao.fetchAvailableRooms();
        return roomsAvailable.contains(roomName);
    }

}
