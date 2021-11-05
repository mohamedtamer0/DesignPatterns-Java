package com.company.Structuraldesignpatterns.facade;

public class Menu {
    private  Italykitchen italykitchen;
    private Frenchkitchen frenchkitchen;

    public Menu() {
        italykitchen = new ItalykitchenImpl();
        frenchkitchen = new FrenchkitchenImpl();
    }


    public void bouillabaisse() {
        frenchkitchen.bouillabaisse();
    }

    public void cassoulet() {
        frenchkitchen.cassoulet();
    }

    public void pouleAuPot() {
        frenchkitchen.pouleAuPot();
    }

    public void lasagneWithTomatoAndCheese() {
        italykitchen.lasagneWithTomatoAndCheese();
    }

    public void prawnRisotto() {
        italykitchen.prawnRisotto();
    }

    public void creamCaramel() {
        italykitchen.creamCaramel();
    }


}
