package com.bolsadeideas.springboot.app.controller;

import com.bolsadeideas.springboot.app.models.entity.Client;
import com.bolsadeideas.springboot.app.models.service.IClientService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@SessionAttributes("client")
public class ClientController {

    private final IClientService clientService;

    @Autowired
    public ClientController(IClientService iClientService) {
        this.clientService = iClientService;
    }

    @GetMapping("/list")
    public String list(@RequestParam(name = "page", defaultValue = "0") int page, Model model){

        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Client> clients = clientService.findAll(pageRequest);

        PageRender<Client> pageRender = new PageRender<>("/list", clients);

        model.addAttribute("listClients", clients);
        model.addAttribute("title", "Client's list");
        model.addAttribute("page", pageRender);
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
            client = clientService.findOne(id);
        } else{
            return "redirect:/list";
        }

        model.put("client", client);
        model.put("title", "Edit Client");


        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Client client, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){

        if(result.hasErrors()){
            model.addAttribute("title", "Client's Formit ");
            return "form";
        }

        String msg = (client.getId() != null) ? "Client edit successfully" : "Client create successfully";
        clientService.save(client);
        status.setComplete();
        flash.addFlashAttribute("success", msg);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if( id > 0) {
            clientService.delete(id);
            flash.addFlashAttribute("success", "Cliente delete");
        }
        return "redirect:/list";
    }


}
