package com.bolsadeideas.springboot.app.controller;

import com.bolsadeideas.springboot.app.models.dao.IClientDao;
import com.bolsadeideas.springboot.app.models.entity.Client;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("client")
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

    @GetMapping("/form/{id}")
    public String edit(@PathVariable(value = "id") Long id,  Map<String, Object> model){

        Client client = null;
        if(id > 0) {
            client = clientDao.findOne(id);
        } else{
            return "redirect:/list";
        }

        model.put("client", client);
        model.put("title", "Form for Client");


        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Client client, BindingResult result, Model model, SessionStatus status){

        if(result.hasErrors()){

            model.addAttribute("title", "Client's Formit ");
            return "form";
        }

        clientDao.save(client);
        status.setComplete();
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        if( id > 0) {
            clientDao.delete(id);
        }
        return "redirect:/list";
    }


}
