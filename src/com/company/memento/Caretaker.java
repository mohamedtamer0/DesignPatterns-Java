package com.company.memento;

public class Caretaker {
    private Memento mMemoto;

    public void archive(Memento memoto) {
        mMemoto = memoto;
    }

    public Memento getMemoto() {
        return mMemoto;
    }
}
