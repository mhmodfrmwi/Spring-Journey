package com.example.products.controllers;

import com.example.products.services.SmsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @GetMapping("/send")
    public String sendSms(@RequestParam String phoneNumber, @RequestParam String message) {
        smsService.sendSms(phoneNumber, message);
        return "SMS sent to " + phoneNumber;
    }

    @PostMapping("/send-default")
    public String sendDefaultSms(@RequestParam String phoneNumber) {
        smsService.sendDefaultSms(phoneNumber);
        return "Default SMS sent to " + phoneNumber;
    }
}