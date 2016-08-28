package com.ankit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ankit07 on 8/28/16.
 */

@Controller
@RequestMapping("/")
public class SpringMVCdemoController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "WELCOME TO SPRING MVC DEMO");
        return "welcome";
    }
}
