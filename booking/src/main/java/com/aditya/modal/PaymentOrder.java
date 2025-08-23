package com.aditya.modal;

import com.aditya.domain.PaymentMethod;
import com.aditya.domain.PaymentOrderStatus;

import lombok.Data;

@Data
public class PaymentOrder {
    private Long id;

    private Long amount;

    private PaymentOrderStatus status;

    private PaymentMethod paymentMethod;

    private String paymentLinkId;

    private Long userId;

    private Long bookingId;
}
