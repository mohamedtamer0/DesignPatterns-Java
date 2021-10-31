package com.company.facade;

public class ItalykitchenImpl implements Italykitchen{
    @Override
    public void lasagneWithTomatoAndCheese() {
        System.out.println("Lasagne With Tomato And Cheese");
    }

    @Override
    public void prawnRisotto() {
        System.out.println("Prawn Risotto");
    }

    @Override
    public void creamCaramel() {
        System.out.println("Cream Caramel");
    }
}
