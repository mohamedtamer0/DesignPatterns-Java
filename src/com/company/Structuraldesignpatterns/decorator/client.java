package com.company.Structuraldesignpatterns.decorator;

public class client {
    public static void main(String[] args) {
        Cake cake = new CakeEmbryo();
        cake.make();

        System.out.println("--------Decorate Fruit Cake--------");
        DecoratorCake fruitCake = new FruitCake(cake);
        fruitCake.make();

    }
}
