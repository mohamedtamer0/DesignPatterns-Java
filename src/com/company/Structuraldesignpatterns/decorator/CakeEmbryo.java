package com.company.Structuraldesignpatterns.decorator;

public class CakeEmbryo implements Cake{
    @Override
    public void make() {
        System.out.println("Baking Cake");
    }
}
