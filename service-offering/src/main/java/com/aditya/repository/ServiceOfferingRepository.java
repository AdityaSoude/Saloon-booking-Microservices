package com.aditya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.modal.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long> {

    Set<ServiceOffering> findBySalonId(Long id);
}
