package com.aditya.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.aditya.domain.BookingStatus;
import com.aditya.modal.*;
import com.aditya.payload.dto.SalonDTO;
import com.aditya.payload.dto.ServiceOfferingDTO;
import com.aditya.payload.dto.UserDTO;
import com.aditya.payload.request.BookingRequest;

public interface BookingService {


    Booking createBooking(
            BookingRequest booking,
            UserDTO user,
            SalonDTO salon,
            Set<ServiceOfferingDTO> serviceOfferingSet) throws Exception;


    List<Booking> getBookingsByCustomer(Long customerId);


    List<Booking> getBookingsBySalon(Long salonId);


    Booking getBookingById(Long bookingId);

    Booking bookingSucess(PaymentOrder order);


    Booking updateBookingStatus(Long bookingId, BookingStatus status) throws Exception;

    SalonReport getSalonReport(Long salonId);

    List<Booking> getBookingsByDate(LocalDate date,Long salonId);
}
