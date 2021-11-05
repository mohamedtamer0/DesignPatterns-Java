package com.company.Behavioraldesignpatterns.memento;

public class Caretaker {
    private Memento mMemoto;

    public void archive(Memento memoto) {
        mMemoto = memoto;
    }

    public Memento getMemoto() {
        return mMemoto;
    }
}
