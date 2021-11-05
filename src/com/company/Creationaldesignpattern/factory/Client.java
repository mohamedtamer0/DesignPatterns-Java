package com.company.Creationaldesignpattern.factory;

public class Client {
    public static void main(String[] args) {
        Factory factory = new CakeFactory();
        MangoCake mangoCake = factory.createProduct(MangoCake.class);
        mangoCake.prepareMaterials();
        mangoCake.baking();
    }
}
