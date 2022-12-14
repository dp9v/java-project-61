package hexlet.code.games;

import hexlet.code.common.Randomizer;
import hexlet.code.common.GameEngine;

import static hexlet.code.common.Constants.DEFAULT_QUESTIONS_COUNT;

public class Prime {
    private static final String INTRO = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int LIMIT = 1000;

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
        var number = Randomizer.nextInt(LIMIT);
        var isPrime = isPrime(number);
        return new String[]{
            Integer.toString(number),
            isPrime ? "yes" : "no"
        };
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
