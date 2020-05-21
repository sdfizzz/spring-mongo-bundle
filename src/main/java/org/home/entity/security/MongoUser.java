package org.home.entity.security;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document(collection="users")
public class MongoUser {

    @MongoId
    String id;

    String username;
    String password;
    List<String> roles;
}
