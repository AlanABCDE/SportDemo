package com.noob.sportsdemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstController {
    @RequestMapping("/HelloWorld")
    public String HelloWorld(){
        return "HelloWorld";
    }
}
