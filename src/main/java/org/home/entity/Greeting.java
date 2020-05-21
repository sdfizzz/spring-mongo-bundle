package org.home.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection="greetings")
public class Greeting {

    @MongoId
    private String id;
    private String message;
    private String fromUser;

    public Greeting(String message, String fromUser) {
        this.message = message;
        this.fromUser = fromUser;
    }
}
