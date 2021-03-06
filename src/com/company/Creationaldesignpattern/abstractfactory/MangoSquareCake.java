package com.company.Creationaldesignpattern.abstractfactory;

public class MangoSquareCake extends CakeFactory{
    @Override
    public CakeCream cream() {
        return new MangoCream();
    }

    @Override
    public CakeStyle style() {
        return new SquareStyle();
    }
}
