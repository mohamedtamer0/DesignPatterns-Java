package com.company.singleton;

public class Counter {

    public int count = 0;

    private static Counter instance = new Counter();

    private Counter() {
    }

    public static Counter getInstance() {
        return instance;
    }

    public void addOne() {
        count++;
    }


    public static void main(String[] args) {
        Counter obj1 = Counter.getInstance();
        Counter obj2 = Counter.getInstance();
        obj1.addOne();
        obj2.addOne();
        System.out.println("Counter 1 : " + obj1.count);
        System.out.println("Counter 2 : " + obj2.count);

        obj1.addOne();
        obj2.addOne();
        System.out.println("Counter 1 : " + obj1.count);
        System.out.println("Counter 2 : " + obj2.count);

    }
}
