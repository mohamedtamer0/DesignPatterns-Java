package com.company.state;

public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        player.gameStart();
        player.killMonster();
        player.gainExperience();
        player.next();
        player.pick();
        player.gameOver();
        player.next();
        player.killMonster();
        player.pick();
    }
}
