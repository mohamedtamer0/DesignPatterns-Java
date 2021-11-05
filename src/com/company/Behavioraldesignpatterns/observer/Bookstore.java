package com.company.Behavioraldesignpatterns.observer;

public class Bookstore implements Observer{

    public Bookstore(Subject magazine) {
        magazine.registerObserver(this);
    }

    @Override
    public void update(String magazine) {
        System.out.println("Our shop updates the magazine today：《" + magazine+ "》");
    }
}
