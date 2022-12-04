package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

import static hexlet.code.Constants.LIMIT;
import static hexlet.code.Constants.LOOPS_COUNT;

public class Gcd {
    private static final Random RANDOM = new Random();


    public static void run(String userName) {
        System.out.println("Find the greatest common divisor of given numbers.");
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
        var firstValue = RANDOM.nextInt(LIMIT);
        var secondValue = RANDOM.nextInt(LIMIT);
        System.out.printf("Question: %d %d\n", firstValue, secondValue);
        System.out.print("Your answer: ");
        var answer = Cli.nextNumber();
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
