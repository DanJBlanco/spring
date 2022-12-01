package com.bolsaideas.springboot.form.app.controllers;

import com.bolsaideas.springboot.form.app.models.domain.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("title", "User Form");
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/form")
    public String processForm(
//            @Valid @ModelAttribute("userInput") User user,
            @Valid User user,
            BindingResult result, Model model
//            ,
//                              @RequestParam String username,
//                              @RequestParam String password,
//                              @RequestParam String email
                              ){

//        model.addAttribute("userTemplate", username);
//        model.addAttribute("passwordTemplate", password);
//        model.addAttribute("emailTemplate", email);

//        User user = User.builder()
//                .username(username)
//                .password(password)
//                .email(email)
//                .build();

        // check validations
        if (result.hasErrors() ){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach( fieldError -> errors.put(fieldError.getField(), "Field ".concat(fieldError.getField()).concat(" ").concat(Objects.requireNonNull(fieldError.getDefaultMessage()))));
            model.addAttribute("errors", errors);
            return "index";
        }

        model.addAttribute("title", "Form result");
        model.addAttribute("userModel", user);

        return "result";
    }

}
