package com.luv2code.springdemo.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {

        return "home";

    }

    // add a request mapping for leaders

    @GetMapping("/leaders")
    public String showLeaderse() {

        return "leaders";

    }

    // add a request mapping for systems

    @GetMapping("/systems")
    public String showSystems() {

        return "systems";

    }

}
