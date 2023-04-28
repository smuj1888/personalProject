package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalDataReader {
    // Path to the animal data CSV file
    protected static final String ANIMAL_DATA_FILE_PATH = "src/main/resources/Animals.csv";

    public static List<Animal> readAnimalData() {
        List<Animal> animals = new ArrayList<>();

        // Open the CSV file
        try (Scanner scanner = new Scanner(new File(ANIMAL_DATA_FILE_PATH))) {
            // Read the header row
            scanner.nextLine();

            // now read the rest of the data
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String name = parts[0];
                int level = Integer.parseInt(parts[1]);
                int strength = Integer.parseInt(parts[2]);
                int gold = Integer.parseInt(parts[3]);
                int hp = Integer.parseInt(parts[4]);
                Animal animal = new Animal(name, level, strength, gold, hp, new RealRandomGenerator());
                animals.add(animal);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not read animal data file: " + e.getMessage());
            System.exit(1);
        }

        return animals;
    }
    public Scanner createScanner(File file) throws FileNotFoundException {
        return new Scanner(file);
    }
}

