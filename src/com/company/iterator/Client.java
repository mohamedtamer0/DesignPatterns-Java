package com.company.iterator;

public class Client {
    public static void main(String[] args) {
        Literature literature = new Literature();
        itr(literature.iterator());


    }

    private static void itr(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
