package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class AnimalDataReaderTest {

    private AnimalDataReader animalDataReader;

    @BeforeEach
    public void setUp() {
        animalDataReader = new AnimalDataReader();
    }

    @Test
    public void testReadAnimalData() throws FileNotFoundException {
        // we will create a spy of the animal data reader class to mock some of its behaviour
        AnimalDataReader spyAnimalDataReader = Mockito.spy(animalDataReader);
        //create the file object so we can read from the CSV file
        File file = new File(AnimalDataReader.ANIMAL_DATA_FILE_PATH);

        //scanner that reads the contents of teh CSV FILE
        try (Scanner scanner = new Scanner(file)) {

            //The spy will return the scanner object when createScanner is called
            Mockito.doReturn(scanner).when(spyAnimalDataReader).createScanner(file);

            //This will call the readAnimalData method using the spy to read the animals from the CSV file
            List<Animal> animals = spyAnimalDataReader.readAnimalData();

            // Test if the number of animals on the file is what we expect
            int expectedNumberOfAnimals = 10;

            assertEquals(expectedNumberOfAnimals, animals.size());

            // Test if the first animals data is correct
            Animal firstAnimal = animals.get(0);
            assertEquals("Rabbit", firstAnimal.getName());
            assertEquals(1, firstAnimal.getLevel());

        }
    }
}
