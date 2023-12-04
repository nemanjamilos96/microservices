package com.microservices.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
@Component
public interface NotificationClient {
    @PostMapping(path = "api/v1/notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
