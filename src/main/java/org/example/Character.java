package org.example;

public class User {

    String name;
    int level;
    int Strength;
    int gold;

    public User(String name, int level, int strength, int gold) {
        this.name = name;
        this.level = level;
        Strength = strength;
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", Strength=" + Strength +
                ", gold=" + gold +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
