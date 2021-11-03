package com.company.commandpatterns;

public class OrderPayCommand implements OrderCommand{

    public Long id;

    public OrderPayCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Paying for order with id : " + id);
    }
}
