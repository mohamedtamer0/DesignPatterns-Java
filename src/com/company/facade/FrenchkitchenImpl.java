package com.company.facade;

public class FrenchkitchenImpl implements Frenchkitchen{
    @Override
    public void bouillabaisse() {
        System.out.println("Bouillabaisse");
    }

    @Override
    public void cassoulet() {
        System.out.println("Cassoulet");
    }

    @Override
    public void pouleAuPot() {
        System.out.println("PouleAuPot");
    }
}
