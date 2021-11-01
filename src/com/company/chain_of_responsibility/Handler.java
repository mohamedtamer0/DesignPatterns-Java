package com.company.chain_of_responsibility;

public abstract class Handler {

    protected Handler successor;

    public abstract int capital();

    public abstract void handle(int money);

    public final void handleRequest(int money) {
        if (money <= capital()) {
            handle(money);
        }else {
            if (null != successor) {
                successor.handleRequest(money);
            }else {
                System.out.println("Your requested funds could not be approved");
            }
        }
    }

}
