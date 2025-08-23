package com.aditya.service;

import java.util.List;
import java.util.Set;

import com.aditya.modal.ServiceOffering;
import com.aditya.payload.dto.CategoryDTO;
import com.aditya.payload.dto.SalonDTO;
import com.aditya.payload.dto.ServiceDTO;

public interface ServiceOfferingService {


    ServiceOffering createService(
            ServiceDTO service,
            SalonDTO salon,
            CategoryDTO category
    );

    com.aditya.modal.ServiceOffering updateService(
            Long serviceId,
            ServiceOffering service
    ) throws Exception;

    Set<ServiceOffering> getAllServicesBySalonId(Long salonId,Long categoryId);

    com.aditya.modal.ServiceOffering getServiceById(Long serviceId);

    Set<ServiceOffering> getServicesByIds(Set<Long> ids);
}
