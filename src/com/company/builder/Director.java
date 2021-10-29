package com.company.builder;

public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }


    public void construct(String color, String licensePlate, String brand) {
        builder.builderColor(color);
        builder.builderLicensePlate(licensePlate);
        builder.builderBrand(brand);
    }
}
