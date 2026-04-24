package com.StageTrack.app.controller;
import org.springframework.stereotype.Controller;   // ← pour @Controller
import org.springframework.web.bind.annotation.GetMapping; // ← pour @GetMapping

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}