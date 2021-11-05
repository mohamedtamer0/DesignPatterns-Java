package com.company.Structuraldesignpatterns.decorator;

public abstract class DecoratorCake implements Cake {
    Cake cake;

    public DecoratorCake(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void make() {
        cake.make();
    }
}
