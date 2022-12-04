package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

import static hexlet.code.Constants.LIMIT;
import static hexlet.code.Constants.LOOPS_COUNT;

public class Calc {
    private static final Random RANDOM = new Random();

    private static final char[] SYMBOLS = {'+', '-', '*'};
    private static final int PLUS_NUMBER = 0;
    private static final int MINIS_NUMBER = 1;
    private static final int MULT_NUMBER = 2;

    public static void run(String userName) {
        System.out.println("What is the result of expression?");
        for (int i = 0; i < LOOPS_COUNT; i++) {
            var result = runLoop();
            if (!result) {
                System.out.printf("Let's try again, %s!\n", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!\n", userName);
    }

    private static boolean runLoop() {
        var leftValue = RANDOM.nextInt(LIMIT);
        var rightValue = RANDOM.nextInt(LIMIT);
        var operator = RANDOM.nextInt(SYMBOLS.length);
        System.out.printf("Question: %d %c %d\n", leftValue, SYMBOLS[operator], rightValue);
        System.out.print("Your answer: ");
        var answer = Cli.nextNumber();
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
