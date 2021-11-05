package com.company.Behavioraldesignpatterns.chain_of_responsibility;

public class Tutor extends Handler{
    @Override
    public int capital() {
        return 100;
    }

    @Override
    public void handle(int money) {
        System.out.println("Approved by the instructor: approved " + money + " Dollar");
    }
}
