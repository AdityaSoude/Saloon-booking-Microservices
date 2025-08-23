package com.aditya.service;

import java.util.List;

import com.aditya.modal.Salon;
import com.aditya.payload.dto.SalonDTO;
import com.aditya.payload.dto.UserDTO;

public interface SalonService {


    Salon createSalon(SalonDTO salon, UserDTO user);

    Salon updateSalon(Long salonId, Salon salon) throws Exception;

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId);

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSalonByCity(String city);
}
