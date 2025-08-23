package com.aditya.mapper;


import org.springframework.stereotype.Service;

import com.aditya.modal.Notification;
import com.aditya.payload.dto.BookingDTO;
import com.aditya.payload.dto.NotificationDTO;

@Service
public class NotificationMapper {

    public NotificationDTO toDTO(Notification notification,
                                                         BookingDTO bookingDTO) {
        if (notification == null) {
            return null;
        }

        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notification.getId());
        notificationDTO.setType(notification.getType());
        notificationDTO.setIsRead(notification.getIsRead());
        notificationDTO.setDescription(notification.getDescription());
        notificationDTO.setUserId(notification.getUserId());
        notificationDTO.setBookingId(notification.getBookingId());
        notificationDTO.setSalonId(notification.getSalonId());



        notificationDTO.setBooking(bookingDTO);

        return notificationDTO;
    }

}
