package com.company.Behavioraldesignpatterns.strategy;

public class Context {
    private Strategy goToStrategy;

    public void setGoToStrategy(Strategy strategy) {
        this.goToStrategy = strategy;
    }

    public void take() {
        goToStrategy.transportation();
    }
}
