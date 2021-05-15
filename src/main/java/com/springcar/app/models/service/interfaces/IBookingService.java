package com.springcar.app.models.service.interfaces;

import com.springcar.app.models.entity.Booking;

import java.util.List;

public interface IBookingService {

    void createBooking(Booking booking);
    void deleteBooking(Integer id);

}
