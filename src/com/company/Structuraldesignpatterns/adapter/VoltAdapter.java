package com.company.Structuraldesignpatterns.adapter;

public class VoltAdapter implements VoltFive{

    private Volt220 volt220;

    public VoltAdapter(Volt220 volt220) {
        this.volt220 = volt220;
    }

    @Override
    public int provideVoltFive() {
        int volt = volt220.provideVolt220();
        return 5;
    }

    public int provideVolt220() {
        return  volt220.provideVolt220();
    }

}
