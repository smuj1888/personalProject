package org.example;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Character player;
    private Animal enemy;
    private List<Animal> animals;
    Random rng = new Random();


    public Game(Character player, Animal enemy) {
        this.player = player;
        this.enemy = enemy;
        this.animals = AnimalDataReader.readAnimalData();
        this.rng = new Random();
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (enemy.isAlive()) {
            System.out.println(enemy.toString());
            System.out.println("Enter a to shoot an arrow at the animal");
            System.out.println("Enter q to quit the game");

            String userSelection = scanner.next().toLowerCase();
            if (userSelection.equals("a")) {
                player.shootAnArrow(enemy);
                if (!enemy.isAlive()) {
                    int xpGained = 50; // assume the character gains 50 XP for killing an enemy
                    player.gainXp(xpGained);
                    System.out.println("You killed " + enemy.getName() + " and get " + enemy.getGold() + " Gold");
                    System.out.println(player.afterBattleToString());
                    System.out.println("");
                    System.out.println("Do you want to continue hunting another animal? (y/n)");

                    String userInput;
                    //Check the user input for either a y or n depending on there choice
                    //Small error checking
                    do {
                        userInput = scanner.next().toLowerCase();
                        if (!userInput.equals("y") && !userInput.equals("n")) {
                            System.out.println("Please select a correct input (y/n)");
                        }
                    } while (!userInput.equals("y") && !userInput.equals("n"));

                    if (userInput.equals("y")) {
                        // get a new random animal from the list
                        enemy = animals.get(rng.nextInt(animals.size()));
                    } else if (userInput.equals("n")) {
                        System.out.println("Thank you for playing ");
                        System.out.println(player.finalStatsToString());
                        System.exit(0);
                    }
                }
            } else if (userSelection.equals("q")) {
                System.out.println("Thank you for playing ");
                System.out.println(player.finalStatsToString());
                System.exit(0);
            }
        }
    }
}