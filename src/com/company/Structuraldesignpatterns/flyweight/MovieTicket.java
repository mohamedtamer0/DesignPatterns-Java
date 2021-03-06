package com.company.Structuraldesignpatterns.flyweight;

import java.util.Random;

public class MovieTicket implements Ticket {

    private String movieName;
    private String price;

    public MovieTicket(String movieName){
        this.movieName = movieName;
        price = "Price " + new Random().nextInt(100);
    }

    @Override

    public void printTicket(String time, String seat) {
        System.out.println("+-------------------+");
        System.out.printf("| %-12s    |\n", movieName);
        System.out.println("|                   |");
        System.out.printf("|       %-12s|\n", time);
        System.out.printf("|       %-12s|\n", seat);
        System.out.printf("|       %-12s|\n", price);
        System.out.println("|                   |");
        System.out.println("+-------------------+");
    }
}
