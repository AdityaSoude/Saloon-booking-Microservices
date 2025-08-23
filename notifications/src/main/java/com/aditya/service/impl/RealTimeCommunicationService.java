package com.aditya.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.aditya.modal.Notification;
import com.aditya.payload.dto.NotificationDTO;


@Controller
@RequiredArgsConstructor
public class RealTimeCommunicationService {


    private final SimpMessagingTemplate simpMessagingTemplate;



    public void sendNotification(NotificationDTO notification) {
        simpMessagingTemplate.convertAndSend(
                "/notification/user/"+notification.getUserId(),
                notification
        );
        simpMessagingTemplate.convertAndSend(
                "/notification/salon/"+notification.getSalonId(),
                notification
        );
    }



}