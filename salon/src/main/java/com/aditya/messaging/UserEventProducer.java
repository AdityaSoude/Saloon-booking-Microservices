package com.aditya.messaging;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aditya.payload.dto.UserDTO;

@Component
@RequiredArgsConstructor
public class UserEventProducer {
//    private final RabbitTemplate rabbitTemplate;

    public void userCreatedEvent(UserDTO userDTO){
        System.out.println("rabbit mq");
    }
}
