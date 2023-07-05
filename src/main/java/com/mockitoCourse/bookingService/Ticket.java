package com.mockitoCourse.bookingService;

public class Ticket {

    private String showId;

    public Ticket(String ShowId) {
    }

    public String getShowId() {
        return showId;
    }

    public String getShowFromId(){
        return getShowId().replace(":", "");
    }
}
