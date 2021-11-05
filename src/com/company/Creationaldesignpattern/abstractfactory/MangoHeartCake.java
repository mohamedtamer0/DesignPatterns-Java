package com.company.Creationaldesignpattern.abstractfactory;

public class MangoHeartCake extends CakeFactory{
    @Override
    public CakeCream cream() {
        return new MangoCream() ;
    }

    @Override
    public CakeStyle style() {
        return new HeartStyle();
    }
}
