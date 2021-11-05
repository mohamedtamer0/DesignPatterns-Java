package com.company.Behavioraldesignpatterns.chain_of_responsibility;

public class Principal extends Handler {
    @Override
    public int capital() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        System.out.println("Approved by the principal: approved " + money + " Dollar");
    }
}
