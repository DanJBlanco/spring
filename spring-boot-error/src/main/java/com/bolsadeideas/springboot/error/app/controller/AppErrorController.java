package com.bolsadeideas.springboot.error.app.controller;

import com.bolsadeideas.springboot.error.app.errors.DataNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class AppErrorController {

    @GetMapping({"/index","/",""})
    public String index(Model model){

//        int val = 100/0;

//        if(Objects.isNull(model.getAttribute("id"))){
//            throw new DataNotFoundException(String.valueOf(model.getAttribute("id")));
//        }

        Optional<Object> getByIdOptional = Optional.ofNullable(model.getAttribute("id"));

        getByIdOptional.orElseThrow( () -> new DataNotFoundException(model.getAttribute("id").toString()));

        return "index";
    }


}
