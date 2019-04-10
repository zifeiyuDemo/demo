package com.example.demo.service.impl;

import com.example.demo.dto.EmailMessage;
import com.example.demo.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * @Author: caoxb
 * @Date: 2018-11-3 13:51
 */
@Slf4j
public class EmailServerImpl implements EmailService {

    @Autowired
    private JavaMailSender sender;

    @Value("${mail.fromAddress}")
    private String sendFrom;

   public void sendSimpleEmail(EmailMessage message){
       // 发送简单邮件
       SimpleMailMessage mailMessage = new SimpleMailMessage();
       mailMessage.setFrom(sendFrom);
       mailMessage.setTo(message.getSendTo());
       mailMessage.setSubject(message.getSubject());
       mailMessage.setText(message.getContent());
       sender.send(mailMessage);
   }

    public void sendHtmlEmail(EmailMessage message){
       // 发送html 模板邮件
        MimeMessage mimeMessage = null;
        try{
            mimeMessage = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setFrom(sendFrom);
            helper.setTo(message.getSendTo());
            helper.setSubject(message.getSubject());
            helper.setText(message.getContent(), true);
            sender.send(mimeMessage);
        }
        catch (Exception e) {
            log.error("send template email error:{}", e);
        }
    }
}
