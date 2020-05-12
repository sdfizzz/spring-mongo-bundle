package org.home.repositories;

import org.home.entity.security.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<MongoUser, String> {
    MongoUser findByUsername(String username);
}