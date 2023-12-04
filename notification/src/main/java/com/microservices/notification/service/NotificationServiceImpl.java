package com.microservices.notification.service;

import com.microservices.notification.model.Notification;
import com.microservices.notification.repository.NotificationRepository;
import com.microservices.clients.notification.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerName())
                        .sender("Microservices")
                        .message(notificationRequest.getMessage())
                        .build()
        );

    }
}
