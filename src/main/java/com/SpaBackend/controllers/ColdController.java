package com.SpaBackend.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpaBackend.models.ColdBooking;
import com.SpaBackend.services.ColdService;

@CrossOrigin(origins = "*")
@RestController
public class ColdController {
    
    private ColdService coldService;

    public ColdController(ColdService coldService) {
        this.coldService = coldService;
    }

    @GetMapping("/coldbooking")
    public List <ColdBooking> getAllWarmBookings() {
        return coldService.getAllColdBookings();
    }

    @GetMapping("/coldbooking/{date}")
    public List <ColdBooking> getWarmBooking(@PathVariable LocalDate date) {
        return coldService.getColdBooking(date);
    }

    @PostMapping("/coldbooking/{date}/{timeSlot}")
    public ColdBooking addColdBooking(@PathVariable LocalDate date, @PathVariable String timeSlot) {
      return coldService.addColdBooking(date, timeSlot);

    }

    @DeleteMapping("/coldbooking/{date}/{timeSlot}")
    public String deleteColdBooking(@PathVariable LocalDate date,@PathVariable String timeSlot) {
        coldService.deleteColdBooking(date,timeSlot);
        return "Deleted coldbooking "+date + " - " +timeSlot;
    }
}
