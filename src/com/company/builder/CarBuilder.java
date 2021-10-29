package com.company.builder;

public class CarBuilder implements Builder {

    Car car;

    public CarBuilder() {
        car = new Car();
    }

    @Override
    public void builderColor(String color) {
        car.setColor(color);
    }

    @Override
    public void builderLicensePlate(String licensePlate) {
        car.setLicensePlate(licensePlate);
    }

    @Override
    public void builderBrand(String brand) {
        car.setBrand(brand);
    }

    @Override
    public Car build() {
        return car;
    }
}
