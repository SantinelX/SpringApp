package com.SDA.company.controller;

import com.SDA.company.models.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginControllerThymeleaf {

    @RequestMapping("/")
    public String index(){
        return "start";
    }

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model){
        if(loginForm.getUserName().equalsIgnoreCase("admin") && loginForm.getPassword().equalsIgnoreCase("1234")){
            return "home";
        } else {
            return "start";
        }
    }

}
