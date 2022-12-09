package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Constants;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Constants.DEFAULT_LIMIT;

public class Calc {
    private static final char[] SYMBOLS = {'+', '-', '*'};
    private static final int PLUS_NUMBER = 0;
    private static final int MINIS_NUMBER = 1;
    private static final int MULT_NUMBER = 2;

    private static final String INTRO = "What is the result of the expression?";

    public static GameData generateGame() {
        var questions = new QuestionData[Constants.DEFAULT_QUESTIONS_COUNT];
        for (int i = 0; i < Constants.DEFAULT_QUESTIONS_COUNT; i++) {
            questions[i] = generateQuestion();
        }
        return new GameData(INTRO, questions);
    }

    private static QuestionData generateQuestion() {
        var leftValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var rightValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var operator = Randomizer.nextInt(SYMBOLS.length);
        return new QuestionData(
            "%d %c %d".formatted(leftValue, SYMBOLS[operator], rightValue),
            Integer.toString(calculate(leftValue, operator, rightValue))
        );
    }
    public static boolean runLoop() {
        var leftValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var rightValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var operator = Randomizer.nextInt(SYMBOLS.length);

        System.out.printf("Question: %d %c %d\n", leftValue, SYMBOLS[operator], rightValue);
        System.out.print("Your answer: ");
        var answer = ConsoleReader.nextNumber();
        var correctAnswer = calculate(leftValue, operator, rightValue);

        if (answer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        }
        System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'.\n", answer, correctAnswer);
        return false;
    }

    private static int calculate(int left, int operation, int right) {
        return switch (operation) {
            case PLUS_NUMBER -> left + right;
            case MINIS_NUMBER -> left - right;
            case MULT_NUMBER -> left * right;
            default -> 0;
        };
    }
}
