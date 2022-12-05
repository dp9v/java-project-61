package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Constants.DEFAULT_LIMIT;

public class Calc {
    private static final char[] SYMBOLS = {'+', '-', '*'};
    private static final int PLUS_NUMBER = 0;
    private static final int MINIS_NUMBER = 1;
    private static final int MULT_NUMBER = 2;

    public static boolean runLoop() {
        var leftValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var rightValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var operator = Randomizer.nextInt(SYMBOLS.length);

        System.out.printf("Question: %d %c %d\n", leftValue, SYMBOLS[operator], rightValue);
        System.out.print("Your answer: ");
        var answer = ConsoleReader.nextNumber();
        var correctAnswer = calculate(leftValue, rightValue, operator);

        if (answer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        }
        System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'.\n", answer, correctAnswer);
        return false;
    }

    private static int calculate(int left, int right, int operation) {
        return switch (operation) {
            case PLUS_NUMBER -> left + right;
            case MINIS_NUMBER -> left - right;
            case MULT_NUMBER -> left * right;
            default -> 0;
        };
    }
}
