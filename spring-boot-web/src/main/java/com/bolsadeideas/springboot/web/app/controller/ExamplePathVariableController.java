package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class ExamplePathVariableController {

    @GetMapping("/string/{id}")
    public String variables(@PathVariable(name = "id") String textInput, Model model){

        return "index";
    }

    @GetMapping("/string/{id}/{name}")
    public String multiVariables(
            @PathVariable(name = "id") String textInput,
            @PathVariable() String name,
            Model model){

        return "index";
    }

}
