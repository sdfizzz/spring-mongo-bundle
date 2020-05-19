package org.home.controllers;

import org.home.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class RootController {

    @GetMapping("/")
    public String hello() {
        return "hello!";
    }

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
}
