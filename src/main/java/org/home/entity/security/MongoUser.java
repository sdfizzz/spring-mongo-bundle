package org.home.entity.security;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;

@Data
@Document(collection="users")
public class MongoUser {

    @Id
    ObjectId id;

    String username;
    String password;
    List<String> roles;
}
