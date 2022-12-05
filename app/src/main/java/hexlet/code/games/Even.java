package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Constants.DEFAULT_LIMIT;

public class Even {

    public static boolean runLoop() {
        var number = Randomizer.nextInt(DEFAULT_LIMIT);
        String expectedAnswer = number % 2 == 0 ? "yes" : "no";

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
}
