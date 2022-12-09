package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Constants;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Constants.DEFAULT_LIMIT;

public class Gcd {
    private static final int LEFT_LIMIT = 1;

    public static QuestionData generateQuestion() {
        var firstValue = Randomizer.nextInt(LEFT_LIMIT, DEFAULT_LIMIT);
        var secondValue = Randomizer.nextInt(LEFT_LIMIT, DEFAULT_LIMIT);
        var expectedAnswer = calculateGcd(firstValue, secondValue);
        return new QuestionData(
            "%d %d".formatted(firstValue, secondValue),
            Integer.toString(expectedAnswer)
        );
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
