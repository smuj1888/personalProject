package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterDataReader {
    // Path to the character data CSV file
    private static final String CHARACTER_DATA_FILE_PATH = "src/main/resources/Characters.csv";

    public static List<Character> readCharacterData() {
        List<Character> characters = new ArrayList<>();

        // Open the CSV file
        try (Scanner scanner = new Scanner(new File(CHARACTER_DATA_FILE_PATH))) {
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
                Character character = new Character("Player", 1, 10, 0, 100, new RealRandomGenerator());

                characters.add(character);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not read character data file: " + e.getMessage());
            System.exit(1);
        }

        return characters;
    }
}
