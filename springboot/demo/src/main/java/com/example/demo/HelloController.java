package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("pesan", "Halo dari Spring Boot!");
        return "home"; // akan load home.html
    }

   @GetMapping("/hello")
    public String helloPage(Model model) {
        model.addAttribute("nama", "Rifqi");
        return "hello";
    }
}
