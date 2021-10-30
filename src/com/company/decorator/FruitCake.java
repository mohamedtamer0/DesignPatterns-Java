package com.company.decorator;

public class FruitCake extends DecoratorCake{

    public FruitCake(Cake cake) {
        super(cake);
    }

    @Override
    public void make() {
        addSomeFruit();
        super.make();
    }

    private void addSomeFruit(){
        System.out.println("Add Some fruit");
    }
}
