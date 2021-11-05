package com.company.Behavioraldesignpatterns.observer;

public class Client {
    public static void main(String[] args) {
        Magazine magazine = new Magazine();

        Subscriber mohamed = new Subscriber(magazine, "Mohamed");
        Subscriber tamer = new Subscriber(magazine, "Tamer");
        Subscriber habiba = new Subscriber(magazine, "Habiba");
        Bookstore bookstore = new Bookstore(magazine);

        magazine.setMagazine("Shock! Today's magazine since...");
    }
}
