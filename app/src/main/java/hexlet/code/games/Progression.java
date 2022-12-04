package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

import static hexlet.code.Constants.LOOPS_COUNT;

public class Progression {
    private static final Random RANDOM = new Random();

    private static final int PROGRESSION_LENGTH = 10;
    private static final int PROGRESSION_CONSTANT_LIMIT = 10;

    public static void run(String userName) {
        System.out.println("What number is missing in the progression?");
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
        var missedElementIndex = RANDOM.nextInt(PROGRESSION_LENGTH);
        var progression = generateProgression();

        System.out.printf("Question: %s\n", generateProgressionString(progression, missedElementIndex));
        System.out.print("Your answer: ");
        var answer = Cli.nextNumber();
        var expectedAnswer = progression[missedElementIndex];

        if (answer == expectedAnswer) {
            System.out.println("Correct!");
            return true;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, expectedAnswer);
        return false;
    }

    public static int[] generateProgression() {
        var result = new int[PROGRESSION_LENGTH];
        var constant = RANDOM.nextInt(PROGRESSION_CONSTANT_LIMIT);
        var currentElement = RANDOM.nextInt(PROGRESSION_CONSTANT_LIMIT);

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            result[i] = currentElement;
            currentElement += constant;
        }
        return result;
    }

    public static String generateProgressionString(int[] progression, int missedElementIndex) {
        var result = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == missedElementIndex) {
                result.append(".. ");
            } else {
                result.append(progression[i]).append(" ");
            }
        }
        return result.toString();
    }
}
