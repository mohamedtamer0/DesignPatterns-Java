package com.company.state;

public interface GameState {
    void killMonster();

    void gainExperience();

    void next();

    void pick();
}
