package com.aditya.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aditya.modal.ServiceOffering;
import com.aditya.payload.dto.CategoryDTO;
import com.aditya.payload.dto.SalonDTO;
import com.aditya.payload.dto.ServiceDTO;
import com.aditya.payload.dto.UserDTO;
import com.aditya.service.ServiceOfferingService;
import com.aditya.service.clients.CategoryFeignClient;
import com.aditya.service.clients.SalonFeignClient;
import com.aditya.service.clients.UserFeignClient;

import java.util.Set;

@RequestMapping("/api/service-offering")
@RestController
@RequiredArgsConstructor
public class ServiceOfferingController {


    private final ServiceOfferingService serviceOfferingService;


    @GetMapping("/salon/{salonId}")
    public ResponseEntity<Set<ServiceOffering>> getServicesBySalonId(
            @PathVariable Long salonId,
            @RequestParam(required = false) Long categoryId) {
        Set<ServiceOffering> services =  serviceOfferingService
                .getAllServicesBySalonId(salonId,categoryId);

            return ResponseEntity.ok(services);

    }


    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceOffering> getServiceById(@PathVariable Long serviceId) throws Exception {
        ServiceOffering service = serviceOfferingService
                .getServiceById(serviceId);
        if (service == null) {
            throw new Exception("service not found with id "+serviceId);
        }
            return ResponseEntity.ok(service);

    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServicesByIds(
            @PathVariable Set<Long> ids) {
        Set<ServiceOffering> services =  serviceOfferingService
                .getServicesByIds(ids);

        return ResponseEntity.ok(services);


    }


}
