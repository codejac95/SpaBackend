package com.SpaBackend.models;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Coldbookings")
public class ColdBooking {
    
    private LocalDate date;
    private String timeSlot;
    
    public ColdBooking(LocalDate date, String timeSlot) {
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
    
}
