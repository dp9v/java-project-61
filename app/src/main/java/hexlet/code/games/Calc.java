package hexlet.code.games;

import hexlet.code.common.Randomizer;
import hexlet.code.common.GameEngine;

import static hexlet.code.common.Constants.DEFAULT_LIMIT;
import static hexlet.code.common.Constants.DEFAULT_QUESTIONS_COUNT;

public class Calc {
    private static final String INTRO = "What is the result of the expression?";
    private static final char[] SYMBOLS = {'+', '-', '*'};
    private static final int PLUS_NUMBER = 0;
    private static final int MINIS_NUMBER = 1;
    private static final int MULT_NUMBER = 2;

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
        var leftValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var rightValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var operator = Randomizer.nextInt(SYMBOLS.length);
        return new String[]{
            "%d %c %d".formatted(leftValue, SYMBOLS[operator], rightValue),
            Integer.toString(calculate(leftValue, operator, rightValue))
        };
    }

    private static int calculate(int left, int operation, int right) {
        return switch (operation) {
            case PLUS_NUMBER -> left + right;
            case MINIS_NUMBER -> left - right;
            case MULT_NUMBER -> left * right;
            default -> throw new RuntimeException("Unknown operator: " + SYMBOLS[operation]);
        };
    }
}
