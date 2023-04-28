package org.example;

public class MockRandomGenerator implements RandomGenerator {
    private int fixedValue;

    public MockRandomGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int nextInt(int bound) {
        return fixedValue;
    }
}
