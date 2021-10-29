package com.company.factory;

public abstract class Factory {
    public abstract <T extends Cake> T createProduct(Class<T> clz);
}
