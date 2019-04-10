package com.example.demo.service;

import com.example.demo.dto.EmailMessage;

/**
 * @Author: caoxb
 * @Date: 2018-11-3 13:16
 */
public interface EmailService {

    void sendSimpleEmail(EmailMessage message);

    void sendHtmlEmail(EmailMessage message);

}
