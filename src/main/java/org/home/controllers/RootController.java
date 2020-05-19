package org.home.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
