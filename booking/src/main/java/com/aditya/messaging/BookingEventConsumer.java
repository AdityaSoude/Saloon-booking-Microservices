package com.aditya.messaging;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

import com.aditya.modal.PaymentOrder;
import com.aditya.service.BookingService;

@Component
@RequiredArgsConstructor
public class BookingEventConsumer {


    private final BookingService bookingService;

    @RabbitListener(queues = "booking-queue")
    public void bookingUpdateListener(PaymentOrder paymentOrder){

        System.out.println("Received message: " + paymentOrder);

        bookingService.bookingSucess(paymentOrder);

        System.out.println("Received message: " + paymentOrder);

    }
}
