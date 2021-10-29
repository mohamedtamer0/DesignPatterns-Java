package com.company.abstractfactory;

public class Client {
    public static void main(String[] args) {
        CakeFactory mangoHeartCake  = new MangoHeartCake();
        mangoHeartCake.cream().cream();
        mangoHeartCake.style().style();

        System.out.println("=================");

        CakeFactory mangoSquareCake = new MangoSquareCake();
        mangoSquareCake.cream().cream();
        mangoSquareCake.style().style();


    }

}
