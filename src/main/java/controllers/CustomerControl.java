package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerControl {
    @GetMapping("")
    public String showHomePage(){
        return "index";
    }
}
