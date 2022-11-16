package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/string")
    public String param(
            @RequestParam(name="text", required = false, defaultValue = "default value") String text,
            Model model){

         model.addAttribute("result", "param value: " + text);

         return "params/look";
     }


    @GetMapping("/mix-params")
    public String param(
            @RequestParam() String greeting,
            @RequestParam() Integer number,
            Model model){

         model.addAttribute("greeting", "param value: " + greeting);
         model.addAttribute("number", "param value: " + number);

         return "params/look";
     }

    @GetMapping("/mix-params")
    public String param(HttpServletRequest request, Model model){
        String greeting = request.getParameter("greeting");
        Integer number = Integer.parseInt(request.getParameter("greeting"));
         model.addAttribute("greeting", "param value: " + greeting);

         return "params/look";
     }





}
