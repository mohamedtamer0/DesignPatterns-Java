package com.company.factory;

public class MangoCake implements Cake{
    @Override
    public void prepareMaterials() {
        System.out.println("prepare Mango Cream");
    }

    @Override
    public void baking() {
        System.out.println("Baking ten minutes");
    }
}
