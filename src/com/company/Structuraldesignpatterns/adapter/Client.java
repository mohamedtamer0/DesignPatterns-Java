package com.company.Structuraldesignpatterns.adapter;

public class Client {
    public static void main(String[] args) {
        Volt220 volt220 = new Volt220();
        VoltAdapter adapter = new VoltAdapter(volt220);

        int volt = adapter.provideVoltFive();
        System.out.println("After adapter, the volt is :" + volt);

    }
}
