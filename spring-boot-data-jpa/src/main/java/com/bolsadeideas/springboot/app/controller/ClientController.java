package com.bolsadeideas.springboot.app.controller;

import com.bolsadeideas.springboot.app.models.dao.IClientDao;
import com.bolsadeideas.springboot.app.models.entity.Client;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class ClientController {

    private final IClientDao clientDao;

    @Autowired
    public ClientController(@Qualifier("clientDaoH2") IClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping("/list")
    public String list(Model model){

        model.addAttribute("listClients", clientDao.findAll());
        model.addAttribute("title", "Client's list");
        return "list";
    }

    @GetMapping("/form")
    public String create(Map<String, Object> model){
        model.put("title", "Form for Client");

        Client client = new Client();
        model.put("client", client);

        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Client client, BindingResult result, Model model){

        if(result.hasErrors()){

            model.addAttribute("title", "Client's Form");
            return "form";
        }

        clientDao.save(client);

        return "redirect:/list";
    }


}
