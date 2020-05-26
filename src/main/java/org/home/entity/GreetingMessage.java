package org.home.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GreetingMessage {
    private Greeting greeting;
    private Date timestamp;
}
