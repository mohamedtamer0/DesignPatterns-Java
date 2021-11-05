package com.company.Behavioraldesignpatterns.strategy;

public class GoToCairo implements Strategy{
    @Override
    public void transportation() {
        System.out.println("take my car");
    }
}
