package com.aditya.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aditya.modal.Category;
import com.aditya.payload.dto.SalonDTO;
import com.aditya.payload.dto.UserDTO;
import com.aditya.service.CategoryService;
import com.aditya.service.clients.SalonFeignClient;
import com.aditya.service.clients.UserFeignClient;

@RestController
@RequestMapping("/api/categories/salon-owner")
@RequiredArgsConstructor
public class SalonCategoryController {

    private final CategoryService categoryService;
    private final SalonFeignClient salonService;


    @PostMapping
    public ResponseEntity<Category> createCategory(
            @RequestBody Category category,
            @RequestHeader("Authorization") String jwt) throws Exception {
        SalonDTO salon=salonService.getSalonByOwner(jwt).getBody();

        Category savedCategory = categoryService.saveCategory(category, salon);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
}
