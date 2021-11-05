package com.company.Behavioraldesignpatterns.state;

public interface GameState {
    void killMonster();

    void gainExperience();

    void next();

    void pick();
}
