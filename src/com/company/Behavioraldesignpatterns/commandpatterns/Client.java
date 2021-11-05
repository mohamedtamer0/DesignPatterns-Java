package com.company.Behavioraldesignpatterns.commandpatterns;

public class Client {
    public static void main(String[] args) {
        CommandProcessor obj = new CommandProcessor();
        obj.addToQueue(new OrderAddCommand(1L));
        obj.addToQueue(new OrderAddCommand(2L));
        obj.addToQueue(new OrderPayCommand(2L));
        obj.addToQueue(new OrderPayCommand(1L));
        obj.processCommands();
    }
}
