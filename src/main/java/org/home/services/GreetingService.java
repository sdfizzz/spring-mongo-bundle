package org.home.services;

import org.home.entity.Greeting;
import org.home.repositories.GreetingRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(final GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    public String getRandomGreetingMessage() {
        List<Greeting> all = greetingRepository.findAll();
        return all.get(ThreadLocalRandom.current().nextInt(all.size())).getMessage();
    }

    public void delete(String id) {
        greetingRepository.deleteById(id);
    }

    public String save(String message, String userId) {
        if (StringUtils.isEmpty(message)) return "message can't be empty";

        // check if greeting exists
        List<Greeting> byMessage = greetingRepository.findByMessage(message);
        if (!byMessage.isEmpty()) return "record exists";

        Greeting saved = greetingRepository.save(new Greeting(message, userId));
        return saved.getId() != null ? "successful" : "";
    }

    public Optional<Greeting> getById(String id) {
        return greetingRepository.findById(id);
    }
}
