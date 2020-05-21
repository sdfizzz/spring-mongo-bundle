package org.home.repositories;

import org.home.entity.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreetingRepository extends MongoRepository<Greeting, String> {
    List<Greeting> findByMessage(String message);
}
