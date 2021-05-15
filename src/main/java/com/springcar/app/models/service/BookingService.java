package com.springcar.app.models.service;

import com.springcar.app.models.dao.IBookingDto;
import com.springcar.app.models.entity.Booking;
import com.springcar.app.models.service.interfaces.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements IBookingService {

    @Autowired
    IBookingDto repository;

    @Override
    public void createBooking(Booking booking) {
        repository.save(booking);
    }

    @Override
    public void deleteBooking(Integer id) {
        repository.deleteById(Long.valueOf(id));
    }
}
