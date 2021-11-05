package com.company.strategy;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        context.setGoToStrategy(new GoToCairo());
        context.take();

        context.setGoToStrategy(new GoToGona());
        context.take();
    }
}
