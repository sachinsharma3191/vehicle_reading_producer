package com.egen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;

@Service
public class VehicleReadingAlertSnsService {

	@Value("${VEHICLE_ALERT_TOPIC}")
	String topic;

	private final NotificationMessagingTemplate notificationMessagingTemplate;

	@Autowired
	public VehicleReadingAlertSnsService(AmazonSNS sns) {
		this.notificationMessagingTemplate = new NotificationMessagingTemplate(sns);
	}

	public void send(String subject, String message) throws Exception {
		this.notificationMessagingTemplate.sendNotification(topic, message, subject);
	}

}
