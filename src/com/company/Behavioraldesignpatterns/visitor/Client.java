package com.company.Behavioraldesignpatterns.visitor;

public class Client {
    public static void main(String[] args) {
        LaborMarket laborMarket = new LaborMarket();
        System.out.println("===== Round 1: Leader =====");
        laborMarket.showApplicants(new Leader());

        /*
        You can add more rounds and implements .............
         */
    }
}
