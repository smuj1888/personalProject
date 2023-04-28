package org.example;

import java.util.Random;

public class Character {

    String name;
    int level;
    int strength;
    int gold;

    int hp;
    boolean isAlive;

    int xp;

    private RandomGenerator randomGenerator;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your character is :").append(System.lineSeparator());
        sb.append("┌─────────┬──────┬─────────┬──────┬────┬────────┬──────┐").append(System.lineSeparator());
        sb.append("│ Name    │ Level│ Strength│ Gold │ HP │ Alive  │ XP   │").append(System.lineSeparator());
        sb.append("├─────────┼──────┼─────────┼──────┼────┼────────┼──────┤").append(System.lineSeparator());
        sb.append(String.format("│ %-7s │ %-4d │ %-7d │ %-4d │ %-2d │ %-6b │ %-4d │",
                name, level, strength, gold, hp, isAlive, xp)).append(System.lineSeparator());
        sb.append("└─────────┴──────┴─────────┴──────┴────┴────────┴──────┘").append(System.lineSeparator());

        return sb.toString();
    }

    public String afterBattleToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your character's stats after the battle: ").append(System.lineSeparator());
        sb.append("┌─────────┬──────┬─────────┬──────┬────┬────────┬──────┐").append(System.lineSeparator());
        sb.append("│ Name    │ Level│ Strength│ Gold │ HP │ Alive  │ XP   │").append(System.lineSeparator());
        sb.append("├─────────┼──────┼─────────┼──────┼────┼────────┼──────┤").append(System.lineSeparator());
        sb.append(String.format("│ %-7s │ %-4d │ %-7d │ %-4d │ %-2d │ %-6b │ %-4d │",
                name, level, strength, gold, hp, isAlive, xp)).append(System.lineSeparator());
        sb.append("└─────────┴──────┴─────────┴──────┴────┴────────┴──────┘").append(System.lineSeparator());

        return sb.toString();
    }

    public String finalStatsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your character's final stats are:  ").append(System.lineSeparator());
        sb.append("┌─────────┬──────┬─────────┬──────┬────┬────────┬──────┐").append(System.lineSeparator());
        sb.append("│ Name    │ Level│ Strength│ Gold │ HP │ Alive  │ XP   │").append(System.lineSeparator());
        sb.append("├─────────┼──────┼─────────┼──────┼────┼────────┼──────┤").append(System.lineSeparator());
        sb.append(String.format("│ %-7s │ %-4d │ %-7d │ %-4d │ %-2d │ %-6b │ %-4d │",
                name, level, strength, gold, hp, isAlive, xp)).append(System.lineSeparator());
        sb.append("└─────────┴──────┴─────────┴──────┴────┴────────┴──────┘").append(System.lineSeparator());

        return sb.toString();
    }





    // the amount of XP needed to level up
    int xpThreshold;

    public Character(String name, int level, int strength, int gold, int hp,RandomGenerator randomGenerator) {
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.gold = gold;
        this.hp = hp;
        this.randomGenerator = randomGenerator;

        // initialize isAlive to true
        isAlive = true;

        xp = 0;

        xpThreshold = 150;

    }

    public void shootAnArrow(Character enemy) {
        int randomNumber = randomGenerator.nextInt(5) + 1;
        int finalHitCalc = randomNumber + getStrength();
        int enemyHpAfterHit = enemy.hp - finalHitCalc;

        if (enemyHpAfterHit <= 0) {
            int enemysGold = enemy.getGold();
            System.out.println("You hit a " + enemy.getName() + " for a " + finalHitCalc + " They are dead");
            // award the player the gold the enemy had
            this.setGold(this.getGold() + enemysGold);
            // set the enemy's isAlive to false
            enemy.isAlive = false;

            // set the enemy's hp to 0
            enemy.setHp(0);

        } else {
            enemy.setHp(enemyHpAfterHit); // update the enemy's hp to the new value
            System.out.println("You hit " + enemy.getName() + " for a " + finalHitCalc + ", The enemy now has " + enemyHpAfterHit + " HP Left");
        }
    }


    public void gainXp(int amount) {
        xp += amount;
        while (xp >= xpThreshold) {
            levelUp();
        }
    }

    public void levelUp() {
        //Everytime the player levels up the xpThreshold will increase by 100
        //Its starts at 150 for the first level
        level++;
        strength += 3;
        //reduce player's XP by the old XP threshold
        xp -= xpThreshold;
        //increase the XP threshold for the next level-up
        xpThreshold += 100;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpThreshold() {
        return xpThreshold;
    }

    public void setXpThreshold(int xpThreshold) {
        this.xpThreshold = xpThreshold;
    }
}
