package com.bolsaideas.springboot.form.app.controllers;

import com.bolsaideas.springboot.form.app.models.domain.User;
import com.bolsaideas.springboot.form.app.validation.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Controller
@SessionAttributes("user")
public class FormController {

    @Autowired
    UserValidator userValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){

        // set validator to TAG @Valid
        binder.addValidators(userValidator);

        String dateFormatString = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

    }

    @GetMapping("/form")
    public String form(Model model){

        User user = new User();
        user.setName("name test");
        user.setLastName("Last name test");
        user.setIdentify("23-L");
        user.setUsername("usernameTest");
        user.setPassword("passwordTest");
        user.setEmail("Emailtest@test.com");
        model.addAttribute("title", "User Form");
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("/form")
    public String processForm(
//            @Valid @ModelAttribute("userInput") User user,
            @Valid User user,
            BindingResult result,
            Model model
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

        // userValidator.validate(user, result);

        if (result.hasErrors() ){
            model.addAttribute("title", "Form error");

            //            Map<String, String> errors = new HashMap<>();
//            result.getFieldErrors().forEach( fieldError -> errors.put(fieldError.getField(), "Field ".concat(fieldError.getField()).concat(" ").concat(Objects.requireNonNull(fieldError.getDefaultMessage()))));
//            model.addAttribute("errors", errors);
            return "index";


        }

        return "redirect:/user";
    }

    @GetMapping("/user")
    public String getUser(@SessionAttribute(value = "user", required = false) User user, Model model, SessionStatus status){

        if(Objects.isNull(user)){
            return "redirect:/form";
        }
        model.addAttribute("title", "Form result");
        status.setComplete();
        return "result";
    }

}
