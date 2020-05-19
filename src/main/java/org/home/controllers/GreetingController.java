package org.home.controllers;

import org.home.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(final GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String list() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return String.format(greetingService.getRandomGreetingMessage(), auth.getName());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestParam() String template) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return greetingService.save(template, auth.getName());
    }

}
