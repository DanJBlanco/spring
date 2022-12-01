package com.bolsaideas.springboot.form.app.controllers;

import com.bolsaideas.springboot.form.app.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("title", "User Form");
        return "index";
    }

    @PostMapping("/form")
    public String processForm(User user, Model model
//            ,
//                              @RequestParam String username,
//                              @RequestParam String password,
//                              @RequestParam String email
                              ){

        model.addAttribute("title", "Form result");
//        model.addAttribute("userTemplate", username);
//        model.addAttribute("passwordTemplate", password);
//        model.addAttribute("emailTemplate", email);

//        User user = User.builder()
//                .username(username)
//                .password(password)
//                .email(email)
//                .build();


        model.addAttribute("userModel", user);

        return "result";
    }

}
