package com.example.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/header")
    public String header() {
        return "header";
    }

    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }

}
