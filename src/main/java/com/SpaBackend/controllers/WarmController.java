package com.SpaBackend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpaBackend.models.WarmBooking;
import com.SpaBackend.services.WarmService;

@RestController
@CrossOrigin(origins = "*")
public class WarmController {

    private WarmService warmService;
    
    public WarmController(WarmService warmService) {
        this.warmService = warmService;
    }
    @GetMapping
    public String getIndex() {
        return "hello warm";
    }
    @GetMapping("/warmbooking")
    public List <WarmBooking> getAllWarmBookings() {
        return warmService.getAllWarmBookings();
    }

    @GetMapping("/warmbooking/{date}")
    public List <WarmBooking> getWarmBooking(@PathVariable LocalDate date) {
        return warmService.getWarmBooking(date);
    }

    @PostMapping("/warmbooking/{date}/{timeSlot}")
    public WarmBooking addWarmBooking(@PathVariable LocalDate date, @PathVariable String timeSlot) {
      return warmService.addWarmBooking(date, timeSlot);

    }

    @DeleteMapping("/warmbooking/{date}/{timeSlot}")
    public String deleteWarmBooking(@PathVariable LocalDate date,@PathVariable String timeSlot) {
        warmService.deleteWarmBooking(date,timeSlot);
        return "Deleted warmbooking "+date + " - " +timeSlot;
    }
}
