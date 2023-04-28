package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    @Mock
    RandomGenerator mockRandomGenerator;

    @BeforeEach
    public void setUp() {

        mockRandomGenerator = Mockito.mock(RandomGenerator.class);
    }

    @Nested
    class ShootAnArrowTests {
        @Mock
        Character enemy;

        @BeforeEach
        public void setUp() {
            enemy = mock(Character.class);
        }

        @Test
        public void testShootAnArrow() {
            Character character = new Character("Attacker", 1, 10, 0, 100, mockRandomGenerator);
            Character enemy = new Character("Enemy", 1, 5, 10, 20, mockRandomGenerator);

            character.shootAnArrow(enemy);

            //Check if the enemy HP is reduced
            assertEquals(9, enemy.getHp());

            //Check if the enemy is still alive
            assertTrue(enemy.isAlive());
        }

        @Test
        public void testShootAnArrowUpdatesEnemyHp() {
            //Configure the player object
            Character player = new Character("Player", 1, 10, 0, 100, mockRandomGenerator);

            //Configure the enemy object
            Character enemy = new Character("Enemy", 1, 5, 10, 50, mockRandomGenerator);

            //Configure the mockRandomGenerator to return a constant value of 5
            when(mockRandomGenerator.nextInt(5)).thenReturn(4);

            //Store the HP of the enemy
            int initialEnemyHp = enemy.getHp();

            //Call the shootAnArrow method
            player.shootAnArrow(enemy);

            //Check if the enemy's HP gets updated
            //4 is the result from mockRandomGenerator, and 1 is added because of the logic in the method
            int expectedEnemyHp = initialEnemyHp - (player.getStrength() + 4 + 1);

            assertEquals(expectedEnemyHp, enemy.getHp());
        }
    }


    @Test
    public void testGainXpWithoutLevelUp() {
        //first we will create a stub object that returns a
        //fixed value of 3
        //this will allow my test to take away the randomness element,
        //so we can test the behaviour properly
        RandomGenerator stubRandomGen = new StubRandomGenerator(3);
        //new character object using the stub random generator
        Character tester = new Character("TesterWithoutLevel",1,10,50,100,stubRandomGen);

        //call the gainXp method in the character class
        tester.gainXp(30);
        //and now our assert equals for both xp and level
        assertEquals(30,tester.getXp());
        assertEquals(1,tester.getLevel());
    }
    @Test
    public void testGainXpWithLevelUp() {
        //first we will create a stub object that returns a
        //fixed value of 3
        //this will allow my test to take away the randomness element,
        //so we can test the behaviour properly
        RandomGenerator stubRandomGen = new StubRandomGenerator(3);

        //new character object using the stub random generator
        Character tester = new Character("TesterWithLevel",1,10,50,100,stubRandomGen);

        tester.gainXp(150);
        assertEquals(0,tester.getXp());
        assertEquals(2,tester.getLevel());
        assertEquals(13,tester.getStrength());

    }


    @Test
    public void testLevelUpIncreasesLevelStrengthAndXpThreshold() {
        //create a new character with 100 XP and set the XP threshold to 150
        Character character = new Character("Test Character", 1, 10, 0, 100, new StubRandomGenerator(1));
        //level up the character
        character.levelUp();
        //increase the level by 1
        assertEquals(2, character.getLevel());
        //increase the strength by 3
        assertEquals(13, character.getStrength());
        //When I call the level up method the characters xp is reduced by the old threshold
        assertTrue(character.getXp() < 200 - 150);
        //ensure that the character's XP threshold has increased by 100
        assertEquals(250, character.getXpThreshold());

    }

}