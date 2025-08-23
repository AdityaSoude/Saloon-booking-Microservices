package com.aditya.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.mapper.NotificationMapper;
import com.aditya.modal.Notification;
import com.aditya.payload.dto.BookingDTO;
import com.aditya.payload.dto.NotificationDTO;
import com.aditya.service.NotificationService;
import com.aditya.service.client.BookingFeignClient;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/notifications/salon-owner")
@RequiredArgsConstructor
public class SalonNotificationController {

    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;
    private final BookingFeignClient bookingFeignClient;

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<List<NotificationDTO>> getNotificationsBySalonId(
            @PathVariable Long salonId) {
        List<Notification> notifications = notificationService
                .getAllNotificationsBySalonId(salonId);
        List<NotificationDTO> notificationDTOS=notifications
                .stream()
                .map((notification)-> {
                    BookingDTO bookingDTO= bookingFeignClient
                            .getBookingById(notification.getBookingId()).getBody();
                    return notificationMapper.toDTO(notification,bookingDTO);
                }).collect(Collectors.toList());
        return ResponseEntity.ok(notificationDTOS);
    }
}
