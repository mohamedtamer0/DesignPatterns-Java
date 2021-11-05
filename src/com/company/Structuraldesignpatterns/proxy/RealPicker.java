package com.company.Structuraldesignpatterns.proxy;

public class RealPicker implements IPicker{
    @Override
    public void receiveMessage() {
        System.out.println("Receive text Message");
    }

    @Override
    public void takeCourier() {
        System.out.println("Take the Courier");
    }

    @Override
    public void signatureAcceptance() {
        System.out.println("Signature Acceptance");
    }
}
