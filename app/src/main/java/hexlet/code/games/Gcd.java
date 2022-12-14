package hexlet.code.games;

import hexlet.code.common.Randomizer;
import hexlet.code.common.GameEngine;

import static hexlet.code.common.Constants.DEFAULT_LIMIT;
import static hexlet.code.common.Constants.DEFAULT_QUESTIONS_COUNT;

public class Gcd {
    private static final int LEFT_LIMIT = 1;
    private static final String INTRO = "Find the greatest common divisor of given numbers.";

    public static void run() {
        GameEngine.run(INTRO, generateQuestions());
    }

    private static String[][] generateQuestions() {
        var result = new String[DEFAULT_QUESTIONS_COUNT][];
        for (int i = 0; i < DEFAULT_QUESTIONS_COUNT; i++) {
            result[i] = generateQuestion();
        }
        return result;
    }

    private static String[] generateQuestion() {
        var firstValue = Randomizer.nextInt(LEFT_LIMIT, DEFAULT_LIMIT);
        var secondValue = Randomizer.nextInt(LEFT_LIMIT, DEFAULT_LIMIT);
        var expectedAnswer = calculateGcd(firstValue, secondValue);
        return new String[]{
            "%d %d".formatted(firstValue, secondValue),
            Integer.toString(expectedAnswer)
        };
    }

    private static int calculateGcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
