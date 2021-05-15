package com.springcar.app.models.dao;

import com.springcar.app.models.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingDto extends CrudRepository<Booking, Long> {
}
