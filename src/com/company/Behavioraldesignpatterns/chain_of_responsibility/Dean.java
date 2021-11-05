package com.company.Behavioraldesignpatterns.chain_of_responsibility;

public class Dean extends Handler {
    @Override
    public int capital() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        System.out.println("Dean approved: approved " + money + " Dollar");
    }
}