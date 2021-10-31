package com.company.facade;

public class Client {
    public static void main(String[] args) {
        Menu menu = new Menu();

        System.out.println("Customer order");
        menu.lasagneWithTomatoAndCheese();
        menu.creamCaramel();

        System.out.println("===========New Order==========");
        System.out.println("Customer two orders");
        menu.bouillabaisse();
        menu.prawnRisotto();

    }
}
