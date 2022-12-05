package hexlet.code.utils;

import java.util.Random;

public class Randomizer {
    private static final Random RANDOM = new Random();

    public static int nextInt(int limit) {
        return RANDOM.nextInt(limit);
    }
}
