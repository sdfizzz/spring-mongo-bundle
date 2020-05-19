package org.home.services;

import org.home.entity.Greeting;
import org.home.repositories.GreetingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(final GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @PreAuthorize("hasRole('USER')")
    public String getRandomGreetingMessage() {
        // todo: refact with cache
        List<Greeting> all = greetingRepository.findAll();
        return all.get(ThreadLocalRandom.current().nextInt(all.size())).getMessage();
    }

    public String save(String message, String userId) {
        if (StringUtils.isEmpty(message)) return "message can't be empty";

        // check if greeting exists
        List<Greeting> byMessage = greetingRepository.findByMessage(message);
        if (!byMessage.isEmpty()) return "record exists";

        Greeting saved = greetingRepository.save(new Greeting(message, userId));
        return saved.getId() != null ? "successful" : "";
    }
}
