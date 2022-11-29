package com.bolsaideas.springboot.app.springbootdi.controllers;

import com.bolsaideas.springboot.app.springbootdi.models.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("invoice")
public class InvoceController {

    @Autowired
    private Invoice invoice;

    @GetMapping({"/", ""})
    public String getInvoice(Model model){

        model.addAttribute("invoice", this.invoice);
        model.addAttribute("title", "Example Invoice with Dependency injection");

        return "invoiceTemplate";
    }
}
