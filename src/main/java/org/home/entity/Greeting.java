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

    public Greeting() {
    }

    public Greeting(String message) {
        this.message = message;
    }

    public Greeting(String id, String message) {
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
}
