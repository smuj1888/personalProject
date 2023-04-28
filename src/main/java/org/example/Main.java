package org.example;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //Read the character data from the CSV file
        List<Character> characters = readCharacterData();

        //Select a random character to play the game with
        Character player = selectRandomCharacter(characters);
        System.out.println(player.toString());

        //Read the animal data from the CSV file
        List<Animal> animals = readAnimalData();
        Animal enemy = selectRandomAnimal(animals);

        //Create a new game with the selected player and animal
        //This will call the game class and will create the playable game
        Game game = new Game(player, enemy);

        //Start the game loop
        game.start();
    }

    //Read the character data from the CSV file and return a list of Character objects, so we can use them in game
    private static List<Character> readCharacterData() {
        return CharacterDataReader.readCharacterData();
    }

    //Select a random character from a list of Character objects and return it, so we can use them in game
    private static Character selectRandomCharacter(List<Character> characters) {
        Random rng = new Random();
        return characters.get(rng.nextInt(characters.size()));
    }

    //Read the animal data from the CSV file and return a list of Animal objects
    private static List<Animal> readAnimalData() {
        return AnimalDataReader.readAnimalData();
    }

    //Select a random animal from a list of Animal objects and return it, so we can use them in game
    private static Animal selectRandomAnimal(List<Animal> animals) {
        Random rng = new Random();
        return animals.get(rng.nextInt(animals.size()));
    }
}

