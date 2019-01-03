package com.example.codeclan.course_service.repositories.BookingRepository;

import com.example.codeclan.course_service.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {
    List<Booking> getAllBookingsForDate(String date);
}
