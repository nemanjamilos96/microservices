package com.microservices.notification.service;

import com.microservices.clients.notification.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}
