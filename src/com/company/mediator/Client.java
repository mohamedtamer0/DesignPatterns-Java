package com.company.mediator;

public class Client {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new UserImpl(mediator, "Tamer");
        User user2 = new UserImpl(mediator, "Mohab");
        User user3 = new UserImpl(mediator, "Mohand");
        User user4 = new UserImpl(mediator, "Habiba");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi everyone!");
    }
}
