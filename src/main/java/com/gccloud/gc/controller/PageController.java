package com.gccloud.gc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/about")
    public String aboutPage(Model model ){

//       sending data to thymleaf
        model.addAttribute("visualRating","4.9/5");
        model.addAttribute("isLogin",true);
        System.out.println("my first home page start");
        return "login";
    }

    @RequestMapping("/services")
    public String servicesPage(Model model ){
        System.out.println("my first home page start");
        return "services";
    }


    @RequestMapping("/login")
    public String loginPage(Model model ){
        model.addAttribute("isLogin",true);
        System.out.println("my first home page start");
        return "login";
    }

    @RequestMapping("/logout")
    public String logoutPage(Model model ){
        System.out.println("my first home page start");
        return "logout";
    }

    @RequestMapping("/home")
    public String homePage(Model model ){
        System.out.println("my first home page start");
        return "home";
    }

    @RequestMapping("/contact")
    public String contactPage(Model model ){
        System.out.println("my first home page start");
        return "contact";
    }



}
