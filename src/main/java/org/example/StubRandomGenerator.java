package org.example;

public class StubRandomGenerator implements RandomGenerator {
    private int fixedValue;

    public StubRandomGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    public int nextInt(int n) {
        return fixedValue;
    }
}
