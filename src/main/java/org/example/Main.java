package org.example;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // Path to the character data CSV file
    private static final String CHARACTER_DATA_FILE_PATH = "src/main/resources/Characters.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> characters = CharacterDataReader.readCharacterData();

        // Select a random character to play the game with
        Random rng = new Random();
        Character player = characters.get(rng.nextInt(characters.size()));
        System.out.println("Your character is " + player.toString());

        List<Animal> animals = AnimalDataReader.readAnimalData();
        Animal enemy = animals.get(new Random().nextInt(animals.size()));

        Game game = new Game(player, enemy);

        game.start();
    }
}
