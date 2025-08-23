package com.aditya.service;

import java.util.List;

import com.aditya.modal.Notification;
import com.aditya.payload.dto.NotificationDTO;

public interface NotificationService {
    NotificationDTO createNotification(Notification notification);
    List<Notification> getAllNotificationsByUserId(Long userId);
    List<Notification> getAllNotificationsBySalonId(Long salonId);
    Notification markNotificationAsRead(Long notificationId) throws Exception;
    void deleteNotification(Long notificationId);
    List<Notification> getAllNotifications();
}
