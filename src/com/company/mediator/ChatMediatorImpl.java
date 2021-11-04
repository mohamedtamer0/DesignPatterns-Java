package com.company.mediator;


import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    private final List<User> users;

    public ChatMediatorImpl() { this.users = new ArrayList<>(); }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User toUser) {
        for (User user : users) {
            //Message should not be received by the user sending it.
            if(user != toUser) { user.receive(msg); }
        }
    }
}