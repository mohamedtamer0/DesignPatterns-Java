package com.company.state;

public class GameStartState implements GameState {

    @Override
    public void killMonster() {
        System.out.println("Kill a Monster");
    }


    @Override
    public void gainExperience() {
        System.out.println("Gain 5 EXP");
    }


    @Override
    public void next() {
        System.out.println("Good! please enter next level");
    }


    @Override
    public void pick() {
        System.out.println("Wow! You pick a good thing");
    }
}