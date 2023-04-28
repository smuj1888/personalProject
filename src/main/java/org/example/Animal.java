package org.example;

public class Enemy extends Character{


    public Enemy(String name, int level, int strength, int gold, int initialHp) {
        super(name, level, strength, gold, initialHp);
        // set the initial HP to 20
        this.setHp(20);
    }

}
