package com.SpaBackend.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.SpaBackend.models.WarmBooking;

@Service
public class WarmService {
    private final MongoOperations mongoOperations;

    public WarmService(MongoOperations mongoOperations) {
        this.mongoOperations=mongoOperations;
    }

    public List <WarmBooking> getAllWarmBookings() {
        return mongoOperations.findAll(WarmBooking.class);
    }
    
    public List <WarmBooking> getWarmBooking(LocalDate date) {
        Query query = Query.query(Criteria.where("date").is(date));
        return mongoOperations.find(query, WarmBooking.class);
    }

    public WarmBooking addWarmBooking(LocalDate date, String timeSlot) {
        WarmBooking booking = new WarmBooking(date, timeSlot);
        mongoOperations.save(booking);
        return booking;
    }


    public void deleteWarmBooking(LocalDate date, String timeSlot) {
        Query query = Query.query(Criteria.where("date").is(date).and("timeSlot").is(timeSlot));
        mongoOperations.remove(query, WarmBooking.class);
    }
}
