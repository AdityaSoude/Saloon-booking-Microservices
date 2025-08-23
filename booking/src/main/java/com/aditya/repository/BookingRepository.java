package com.aditya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.modal.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerId(Long customerId);
    List<Booking> findBySalonId(Long salonId);

}
