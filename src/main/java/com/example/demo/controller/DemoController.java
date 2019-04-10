package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @RequestMapping("/index")
    public String home(Model model){
        model.addAttribute("message", "hello");
        log.info("model:{}", model);
        return "index";
    }

    @RequestMapping("/say")
    @ResponseBody
    public String sayHi(){
        return "Hello Word";
    }
}
