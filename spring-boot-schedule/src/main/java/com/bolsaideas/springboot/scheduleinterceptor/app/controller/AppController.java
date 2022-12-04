package com.bolsaideas.springboot.scheduleinterceptor.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Value("${config.schedule.open}")
    private int OPEN;

    @Value("${config.schedule.close}")
    private int CLOSE;

    @GetMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("title", "Welcome to schedule.");
        return "index";
    }

    @GetMapping("/close")
    public String close(Model model){

        StringBuilder message = new StringBuilder("Close, please visit us from ");
        message.append(OPEN).append(" to ").append(CLOSE).append("Hs. Thank you ❤️");

        model.addAttribute("title", "Welcome to schedule.");
        model.addAttribute("message", message.toString());
        return "close";

    }

}
