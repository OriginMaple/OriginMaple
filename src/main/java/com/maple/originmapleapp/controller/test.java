package com.maple.originmapleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {

    @GetMapping("/")
    public String test (){
        return "index";
    }
}
