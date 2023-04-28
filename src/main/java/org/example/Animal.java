package org.example;

public class Animal extends Character{


    public Animal(String name, int level, int strength, int gold, int hp, RandomGenerator randomGenerator) {
        super(name, level, strength, gold, hp, randomGenerator);
        this.setHp(20);
        boolean isAlive = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The Animal you are hunting is: ").append(System.lineSeparator());
        sb.append("┌─────────┬──────┬─────────┬──────┬────┬──────┐").append(System.lineSeparator());
        sb.append("│ Name    │ Level│ Strength│ Gold │ HP │ Gold │").append(System.lineSeparator());
        sb.append("├─────────┼──────┼─────────┼──────┼────┼──────┤").append(System.lineSeparator());
        sb.append(String.format("│ %-7s │ %-4d │ %-7d │ %-4d │ %-2d │ %-4d │",
                getName(), getLevel(), getStrength(), getGold(), getHp(), getGold())).append(System.lineSeparator());
        sb.append("└─────────┴──────┴─────────┴──────┴────┴──────┘").append(System.lineSeparator());

        return sb.toString();
    }
}
