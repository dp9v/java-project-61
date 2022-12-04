package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

import static hexlet.code.Constants.LIMIT;
import static hexlet.code.Constants.LOOPS_COUNT;

public class Even {

    private static final Random RANDOM = new Random();

    public static void run(String userName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
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
        String expectedAnswer = number % 2 == 0 ? "yes" : "no";

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
}
