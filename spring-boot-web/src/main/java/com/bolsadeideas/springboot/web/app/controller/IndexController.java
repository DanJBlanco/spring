package com.bolsadeideas.springboot.web.app.controller;

import com.bolsadeideas.springboot.web.app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

//    @RequestMapping( value = "/index", method = RequestMethod.GET)
//    @GetMapping("/index")
//    @GetMapping({"/index", "/", "/home"})
//    public String index(ModelMap model) {
//        String html = "index";
//        model.addAttribute("title", "Spring Framework!!");
    @GetMapping({"/index", "/", "/home"})
    public ModelAndView index(ModelAndView mv) {
        String html = "index";
        mv.addObject("title", "Spring Framework con Model and View");
        mv.setViewName(html);
        return mv;
    }


    @GetMapping("/profile")
    public String profile(Model mv) {

        User user = new User();
        user.setName("Dan");
        user.setLastName("Wh");

        user.setEmail("d_j@g.c");

        mv.addAttribute("title", "Spring profile: " + user.getName());
        mv.addAttribute("user", user);


      return "profile";

    }

    @ModelAttribute("userList")
    public List<User> fillUsers(){

        List<User> userList = new ArrayList<>();
        userList.add(new User("User1", "Last1","email1.g.c"));
        userList.add(new User("User2", "Last2","email2.g.c"));
        userList.add(new User("User3", "Last3","email3.g.c"));

        return userList;

    }

}
