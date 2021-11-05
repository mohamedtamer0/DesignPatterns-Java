package com.company.Creationaldesignpattern.factory;

public class CakeFactory extends Factory{

    @Override
    public <T extends Cake> T createProduct(Class<T> clz) {
        Cake cake = null;
        try {
            cake = (Cake) Class.forName(clz.getName()).getDeclaredConstructor().newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  (T) cake;
    }
}
