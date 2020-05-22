package org.home.controllers;

import org.home.entity.Greeting;
import org.home.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(final GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String get(@PathVariable String id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<Greeting> greet = greetingService.getById(id);
        return greet.isPresent() ? String.format(greet.get().getMessage(), auth.getName()) : "";
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Greeting> list() {
        return greetingService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestBody Map<String, String> reqBody) {
        String template = reqBody.get("template");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return greetingService.save(template, auth != null ? auth.getName() : "");
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody Map<String, String> reqBody) {
        String templateId = reqBody.get("id");
        if (!StringUtils.isEmpty(templateId))
            greetingService.delete(templateId);
    }
}
