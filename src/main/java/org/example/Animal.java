package org.example;

public class Animal extends Character{


    public Animal(String name, int level, int strength, int gold, int hp, RandomGenerator randomGenerator) {
        super(name, level, strength, gold, hp, randomGenerator);
        this.setHp(20);
        boolean isAlive = true;
    }
}
