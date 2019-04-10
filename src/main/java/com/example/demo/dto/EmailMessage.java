package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: caoxb
 * @Date: 2018-11-3 13:17
 */
@Getter
@Setter
public class EmailMessage {

    // 收件人地址
    private String sendTo;
    // 邮件主题
    private String subject;
    // 邮件内容
    private String content;


}
