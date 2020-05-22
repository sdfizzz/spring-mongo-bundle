package org.home.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="greetings")
public class Greeting {

    @Id
    private String id;
    private String message;
    private String fromUser;

    public Greeting(String message, String fromUser) {
        this.message = message;
        this.fromUser = fromUser;
    }
}
