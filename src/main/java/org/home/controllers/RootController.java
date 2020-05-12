package org.home.controllers;

import org.home.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RootController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    @ResponseStatus(HttpStatus.OK)
    public String getGreeting() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return String.format(greetingService.getRandomGreetingMessage(), auth.getName());
    }

    @PostMapping("/greeting/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addGreeting(@RequestParam() String template) {
        return greetingService.save(template);
    }
}
