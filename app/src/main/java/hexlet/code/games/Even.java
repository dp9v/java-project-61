package hexlet.code.games;

import hexlet.code.common.Randomizer;
import hexlet.code.common.GameEngine;

import static hexlet.code.common.Constants.DEFAULT_LIMIT;
import static hexlet.code.common.Constants.DEFAULT_QUESTIONS_COUNT;

public class Even {
    private static final String INTRO = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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

    public static String[] generateQuestion() {
        var number = Randomizer.nextInt(DEFAULT_LIMIT);
        return new String[]{
            Integer.toString(number),
            isEven(number) ? "yes" : "no"
        };
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
