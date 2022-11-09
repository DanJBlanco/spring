package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
