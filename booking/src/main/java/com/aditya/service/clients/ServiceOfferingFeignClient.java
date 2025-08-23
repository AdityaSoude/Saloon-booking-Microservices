package com.aditya.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aditya.payload.dto.ServiceOfferingDTO;

import java.util.Set;

@FeignClient("service-offering")
public interface ServiceOfferingFeignClient {

    @GetMapping("/api/service-offering/list/{ids}")
    public ResponseEntity<Set<ServiceOfferingDTO>> getServicesByIds(
            @PathVariable Set<Long> ids);
}
