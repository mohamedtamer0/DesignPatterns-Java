package com.company.decorator;

public class CakeEmbryo implements Cake{
    @Override
    public void make() {
        System.out.println("Baking Cake");
    }
}
