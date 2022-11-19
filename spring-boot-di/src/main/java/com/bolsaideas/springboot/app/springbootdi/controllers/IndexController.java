package com.bolsaideas.springboot.app.springbootdi.controllers;

import com.bolsaideas.springboot.app.springbootdi.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

//    // without dependency injection
//    private MyService service = new MyService();
    @Autowired
    private IService service;

    @GetMapping({"/", "", "/index"})
    public String index(Model model){

        model.addAttribute("obj", service.operation("input from Index controller"));
        return "index";
    }
}
