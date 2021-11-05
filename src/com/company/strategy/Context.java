package com.company.strategy;

public class Context {
    private Strategy goToStrategy;

    public void setGoToStrategy(Strategy strategy) {
        this.goToStrategy = strategy;
    }

    public void take() {
        goToStrategy.transportation();
    }
}
