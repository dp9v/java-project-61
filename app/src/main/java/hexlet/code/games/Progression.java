package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Randomizer;

public class Progression {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int PROGRESSION_CONSTANT_LIMIT = 10;

    public static boolean runLoop() {
        var missedElementIndex = Randomizer.nextInt(PROGRESSION_LENGTH);
        var progression = generateProgression();

        System.out.printf("Question: %s\n", generateProgressionString(progression, missedElementIndex));
        System.out.print("Your answer: ");
        var answer = ConsoleReader.nextNumber();
        var expectedAnswer = progression[missedElementIndex];

        if (answer == expectedAnswer) {
            System.out.println("Correct!");
            return true;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, expectedAnswer);
        return false;
    }

    private static int[] generateProgression() {
        var result = new int[PROGRESSION_LENGTH];
        var constant = Randomizer.nextInt(PROGRESSION_CONSTANT_LIMIT);
        var currentElement = Randomizer.nextInt(PROGRESSION_CONSTANT_LIMIT);

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            result[i] = currentElement;
            currentElement += constant;
        }
        return result;
    }

    private static String generateProgressionString(int[] progression, int missedElementIndex) {
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
