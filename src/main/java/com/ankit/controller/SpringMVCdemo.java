package com.ankit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ankit07 on 8/27/16.
 */
@Controller
public class SpringMVCdemo {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome(ModelMap model){

        model.addAttribute("greeting","welcome !!!!");
        return "welcome";

    }
}
