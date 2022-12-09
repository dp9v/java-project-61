package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Constants;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Constants.DEFAULT_LIMIT;

public class Gcd {
    private static final String INTRO = "Find the greatest common divisor of given numbers.";
    private static final int LEFT_LIMIT = 1;

    public static GameData generateGame() {
        var questions = new QuestionData[Constants.DEFAULT_QUESTIONS_COUNT];
        for (int i = 0; i < Constants.DEFAULT_QUESTIONS_COUNT; i++) {
            questions[i] = generateQuestion();
        }
        return new GameData(INTRO, questions);
    }

    private static QuestionData generateQuestion() {
        var firstValue = Randomizer.nextInt(LEFT_LIMIT, DEFAULT_LIMIT);
        var secondValue = Randomizer.nextInt(LEFT_LIMIT, DEFAULT_LIMIT);
        var expectedAnswer = calculateGcd(firstValue, secondValue);
        return new QuestionData(
            "%d %d".formatted(firstValue, secondValue),
            Integer.toString(expectedAnswer)
        );
    }

    @Deprecated
    public static boolean runLoop() {
        var firstValue = Randomizer.nextInt(LEFT_LIMIT, DEFAULT_LIMIT);
        var secondValue = Randomizer.nextInt(LEFT_LIMIT, DEFAULT_LIMIT);
        System.out.printf("Question: %d %d\n", firstValue, secondValue);
        System.out.print("Your answer: ");
        var answer = ConsoleReader.nextNumber();
        var correctAnswer = calculateGcd(firstValue, secondValue);

        if (answer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        }
        System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'.\n", answer, correctAnswer);
        return false;
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
