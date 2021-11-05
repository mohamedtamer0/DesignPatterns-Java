package com.company.Behavioraldesignpatterns.observer;

public class Subscriber implements Observer {

    private final String subscriber;

    public Subscriber(Subject magazine, String subscriber) {
        magazine.registerObserver(this);
        this.subscriber = subscriber;
    }

    @Override
    public void update(String magazine) {
        System.out.println("Dear" + subscriber + ": Your magazine has arrived, and today’s magazine is called《" + magazine +"》");
    }
}