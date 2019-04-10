package com.example.demo.controller;

import com.example.demo.service.RegisterService;
import com.example.demo.service.TestDbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    private TestDbService testDbService;

    @ResponseBody
    @GetMapping(value = "/record")
    public void register(){
        log.info("insert record time:{}");
            //testDbService.insertRecord(10);
        testDbService.insertRecord(3700);
    }
}


