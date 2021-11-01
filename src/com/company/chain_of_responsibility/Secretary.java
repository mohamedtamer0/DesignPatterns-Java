package com.company.chain_of_responsibility;

public class Secretary extends Handler {
    @Override
    public int capital() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        System.out.println("Secretary approved: approved " + money + " Dollar");
    }
}
