package com.company.Structuraldesignpatterns.proxy;

public class Client {
    public static void main(String[] args) {
        IPicker picker = new RealPicker();
        ProxyPicker proxyPicker = new ProxyPicker(picker);

        proxyPicker.receiveMessage();
        proxyPicker.takeCourier();
        proxyPicker.signatureAcceptance();

    }
}
