package org.home.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import java.math.BigInteger;

@Document(collection="greetings")
public class Greeting {

    @Id
    private String id;
    private String message;
    private String fromUser;

    public Greeting() {
    }

    public Greeting(String message, String userId) {
        this.message = message;
        this.fromUser = userId;
    }

    public Greeting(String id, String message, String userId) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
}
