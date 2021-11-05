package com.company.Behavioraldesignpatterns.state;

public class Player {

    GameState state;

    public void setState(GameState state) {
        this.state = state;
    }

    public void gameStart() {
        setState(new GameStartState());
        System.out.println("\n-----Game Start, ready to fight-----\n");
    }

    public void gameOver() {
        setState(new GameOverState());
        System.out.println("\n-----         Game Over        -----\n");
    }

    public void killMonster() {
        state.killMonster();
    }

    public void gainExperience() {
        state.gainExperience();
    }

    public void next() {
        state.next();
    }

    public void pick() {
        state.pick();
    }


}