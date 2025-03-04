package com.example.products.services;

import com.example.products.models.SmsProperties;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    private final SmsProperties smsProperties;

    public SmsService(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }

    public void sendSms(String phoneNumber, String message) {
        System.out.println("Sending SMS...");
        System.out.println("API Key: " + smsProperties.getApiKey());
        System.out.println("Sender ID: " + smsProperties.getSenderId());
        System.out.println("To: " + phoneNumber);
        System.out.println("Message: " + message);
        System.out.println("SMS sent successfully!");
    }

    public void sendDefaultSms(String phoneNumber) {
        sendSms(phoneNumber, smsProperties.getDefaultMessage());
    }
}