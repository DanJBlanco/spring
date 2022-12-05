package com.bolsadeideas.springboot.error.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppErrorController {

    @GetMapping({"/index","/",""})
    public String index(){

        int val = 100/0;

        return "index";
    }


}
