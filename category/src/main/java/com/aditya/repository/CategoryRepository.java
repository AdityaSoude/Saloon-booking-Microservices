package com.aditya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.modal.Category;

import java.util.Set;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Set<Category> findBySalonId(Long id);
}
