package com.SpaBackend.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.SpaBackend.models.ColdBooking;

@Service
public class ColdService {
    private final MongoOperations mongoOperations;

    public ColdService(MongoOperations mongoOperations) {
        this.mongoOperations=mongoOperations;
    }

    public List <ColdBooking> getAllColdBookings() {
        return mongoOperations.findAll(ColdBooking.class);
    }
    
    public List <ColdBooking> getColdBooking(LocalDate date) {
        Query query = Query.query(Criteria.where("date").is(date));
        return mongoOperations.find(query, ColdBooking.class);
    }

    public ColdBooking addColdBooking(LocalDate date, String timeSlot) {
        ColdBooking booking = new ColdBooking(date, timeSlot);
        mongoOperations.save(booking);
        return booking;
    }


    public void deleteColdBooking(LocalDate date, String timeSlot) {
        Query query = Query.query(Criteria.where("date").is(date).and("timeSlot").is(timeSlot));
        mongoOperations.remove(query, ColdBooking.class);
    }
}
