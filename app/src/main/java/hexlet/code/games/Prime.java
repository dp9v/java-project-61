package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Randomizer;

public class Prime {
    private static final int LIMIT = 1000;

    public static boolean runLoop() {
        var number = Randomizer.nextInt(LIMIT);
        var isPrime = isPrime(number);
        String expectedAnswer = isPrime ? "yes" : "no";

        System.out.printf("Question: %s\n", number);
        System.out.print("Your answer: ");
        var answer = ConsoleReader.nextLine();

        if (answer.equals(expectedAnswer)) {
            System.out.println("Correct!");
            return true;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, expectedAnswer);
        return false;
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
