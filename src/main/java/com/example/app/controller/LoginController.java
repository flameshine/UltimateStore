package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the application login page.
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}