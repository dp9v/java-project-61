package hexlet.code.games;

import hexlet.code.common.Randomizer;
import hexlet.code.engine.QuestionData;

import static hexlet.code.common.Constants.DEFAULT_LIMIT;

public class Calc {
    private static final char[] SYMBOLS = {'+', '-', '*'};
    private static final int PLUS_NUMBER = 0;
    private static final int MINIS_NUMBER = 1;
    private static final int MULT_NUMBER = 2;

    public static QuestionData generateQuestion() {
        var leftValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var rightValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var operator = Randomizer.nextInt(SYMBOLS.length);
        return new QuestionData(
            "%d %c %d".formatted(leftValue, SYMBOLS[operator], rightValue),
            Integer.toString(calculate(leftValue, operator, rightValue))
        );
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
