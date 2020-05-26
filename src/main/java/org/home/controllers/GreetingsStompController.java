package org.home.controllers;

import org.home.entity.GreetingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Controller
@RepositoryEventHandler
public class GreetingsStompController {

    private final String MESSAGE_PREFIX = "/topic";
    private final SimpMessagingTemplate websocket;

    private final EntityLinks entityLinks;

    @Autowired
    public GreetingsStompController(SimpMessagingTemplate websocket,
                                    EntityLinks entityLinks) {
        this.websocket = websocket;
        this.entityLinks = entityLinks;
    }

    @HandleAfterCreate
    public void newEmployee(GreetingMessage message) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/newMessage", getPath(message));
    }

    @HandleAfterDelete
    public void deletemessage(GreetingMessage message) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/deleteMessage", getPath(message));
    }

    @HandleAfterSave
    public void updateEmployee(GreetingMessage employee) {
        this.websocket.convertAndSend(
                MESSAGE_PREFIX + "/updateEmployee", getPath(employee));
    }

    private String getPath(GreetingMessage message) {
        return this.entityLinks.linkForItemResource(message.getClass(),
                message.getGreeting().getId()).toUri().getPath();
    }

}