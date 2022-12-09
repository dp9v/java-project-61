package hexlet.code.common;

import java.util.Random;

public class Randomizer {
    private static final Random RANDOM = new Random();

    public static int nextInt(int limit) {
        return RANDOM.nextInt(0, limit);
    }

    public static int nextInt(int leftLimit, int rightLimit) {
        return RANDOM.nextInt(leftLimit, rightLimit);
    }
}
