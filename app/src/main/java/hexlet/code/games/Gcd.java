package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Constants.DEFAULT_LIMIT;

public class Gcd {
    public static boolean runLoop() {
        var firstValue = Randomizer.nextInt(DEFAULT_LIMIT);
        var secondValue = Randomizer.nextInt(DEFAULT_LIMIT);
        System.out.printf("Question: %d %d\n", firstValue, secondValue);
        System.out.print("Your answer: ");
        var answer = ConsoleReader.nextNumber();
        var correctAnswer = calculate(firstValue, secondValue);

        if (answer == correctAnswer) {
            System.out.println("Correct!");
            return true;
        }
        System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'.\n", answer, correctAnswer);
        return false;
    }

    private static int calculate(int a, int b) {
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
