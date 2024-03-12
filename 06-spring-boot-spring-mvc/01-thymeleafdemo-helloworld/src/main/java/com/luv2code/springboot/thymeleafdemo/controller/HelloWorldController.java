package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }
    // need controller method to process HTML form

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need controller method to read form data and add data to model

    @RequestMapping("/processFormVersionTwo")
    public String letsShout(HttpServletRequest request, Model model) {

        // read request parameter from HTML form
        String theName = request.getParameter("studentName");


        // convert data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        // convert data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey my friend! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
