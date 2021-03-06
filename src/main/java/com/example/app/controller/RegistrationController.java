package com.example.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.example.app.service.UserService;
import com.example.app.entity.User;

/**
 * Controller for the application registration page.
 */

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public ModelAndView registration() {

        var modelAndView = new ModelAndView("/registration");

        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(@Valid User user, BindingResult bindingResult) {

        var modelAndView = new ModelAndView("/registration");

        if (userService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "error.user", "This username is already taken.");
        }

        if (userService.findByEmail(user.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "error.user", "This email is already taken.");
        }

        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            bindingResult.rejectValue("passwordConfirmation", "error.user", "Password mismatch.");
        }

        if (!bindingResult.hasErrors()) {
            userService.save(user);
            modelAndView.addObject("message", "User has been registered successfully.");
        }

        return modelAndView;
    }
}