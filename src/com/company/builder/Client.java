package com.company.builder;

public class Client {
    public static void main(String[] args) {
        Builder builder = new CarBuilder();
        Director director = new Director(builder);
        director.construct("Red","A88888","Ferrari");
        System.out.println(builder.build().toString());


    }
}
