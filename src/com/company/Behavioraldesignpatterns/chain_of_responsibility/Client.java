package com.company.Behavioraldesignpatterns.chain_of_responsibility;

public class Client {
    public static void main(String[] args) {

        Tutor tutor = new Tutor();
        Secretary secretary = new Secretary();
        Dean dean = new Dean();
        Principal principal = new Principal();

        tutor.successor = secretary;
        secretary.successor = dean;
        dean.successor = principal;
        principal.successor = null;

        tutor.handleRequest(12000);
        secretary.handleRequest(100);


    }
}
