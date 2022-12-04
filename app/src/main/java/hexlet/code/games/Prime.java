package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

import static hexlet.code.Constants.LOOPS_COUNT;

public class Prime {

    private static final Random RANDOM = new Random();

    private static final int LIMIT = 1000;

    public static void run(String userName) {
        System.out.println("Answer 'yes' if the number is prime. Otherwise answer 'no'.");
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
        var number = RANDOM.nextInt(LIMIT);
        var isPrime = isPrime(number);
        String expectedAnswer = isPrime ? "yes" : "no";

        System.out.printf("Question: %s\n", number);
        System.out.print("Your answer: ");
        var answer = Cli.nextLine();

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
