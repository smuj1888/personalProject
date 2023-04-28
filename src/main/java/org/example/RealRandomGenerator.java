package org.example;

import java.util.Random;

public class RealRandomGenerator implements RandomGenerator {
    private Random random = new Random();

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
