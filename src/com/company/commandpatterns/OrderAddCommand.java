package com.company.commandpatterns;

public class OrderAddCommand implements OrderCommand{
    public Long id;

    public OrderAddCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Adding Order With id : " + id);
    }
}
