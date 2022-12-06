package com.bolsadeideas.springboot.error.app.controller;

import com.bolsadeideas.springboot.error.app.errors.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler({ArithmeticException.class})
    public String arithmeticError(ArithmeticException ex, Model model){

        model.addAttribute("error", "Arithmetical ERROR");
        model.addAttribute("messageError", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "error/arithmetic";
    }
    @ExceptionHandler({DataNotFoundException.class})
    public String arithmeticError(DataNotFoundException ex, Model model){

        model.addAttribute("error", "Arithmetical ERROR");
        model.addAttribute("messageError", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return "error/arithmetic";
    }

}
