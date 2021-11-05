package com.company.Creationaldesignpattern.builder;

public interface Builder {
    void builderColor(String color);

    void builderLicensePlate(String licensePlate);

    void builderBrand(String brand);

    Car build();
}
