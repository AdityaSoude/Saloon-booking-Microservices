package com.aditya.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.aditya.modal.ServiceOffering;
import com.aditya.payload.dto.CategoryDTO;
import com.aditya.payload.dto.SalonDTO;
import com.aditya.payload.dto.ServiceDTO;
import com.aditya.repository.ServiceOfferingRepository;
import com.aditya.service.ServiceOfferingService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingImpl implements ServiceOfferingService {


    private final ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(ServiceDTO service,
                                         SalonDTO salon,
                                         CategoryDTO category) {
        ServiceOffering serviceOffering=new ServiceOffering();
        serviceOffering.setName(service.getName());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setPrice(service.getPrice());
        serviceOffering.setDuration(service.getDuration());
        serviceOffering.setImage(service.getImage());
        serviceOffering.setSalonId(salon.getId());
        serviceOffering.setCategoryId(category.getId());
        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {
        Optional<ServiceOffering> existingService = serviceOfferingRepository.findById(serviceId);
        if (existingService.isPresent()) {
            ServiceOffering updatedService = existingService.get();
            updatedService.setName(service.getName());
            updatedService.setDescription(service.getDescription());
            updatedService.setPrice(service.getPrice());
            updatedService.setDuration(service.getDuration());
            if(service.getImage()!=null){
                updatedService.setImage(service.getImage());
            }

            return serviceOfferingRepository.save(updatedService);
        } else {
            throw new Exception("Service not found");
        }
    }

    @Override
    public Set<ServiceOffering> getAllServicesBySalonId(Long salonId,
                                                        Long categoryId) {
        Set<ServiceOffering> services = serviceOfferingRepository.findBySalonId(salonId);
        if(categoryId != null) {
            services=services.stream()
                    .filter(service -> service.getCategoryId() != null && service.getCategoryId().equals(categoryId))
                    .collect(Collectors.toSet());
        }

        return services;
    }

    @Override
    public ServiceOffering getServiceById(Long serviceId) {
        Optional<ServiceOffering> service = serviceOfferingRepository
                .findById(serviceId);
        return service.orElse(null);
    }


    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> services = serviceOfferingRepository
                .findAllById(ids);
        return new HashSet<>(services);
    }
}
