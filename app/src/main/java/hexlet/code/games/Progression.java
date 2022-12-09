package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Constants;
import hexlet.code.utils.Randomizer;

public class Progression {
    private static final String INTRO = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int PROGRESSION_CONSTANT_LIMIT = 10;

    public static GameData generateGame() {
        var questions = new QuestionData[Constants.DEFAULT_QUESTIONS_COUNT];
        for (int i = 0; i < Constants.DEFAULT_QUESTIONS_COUNT; i++) {
            questions[i] = generateQuestion();
        }
        return new GameData(INTRO, questions);
    }

    public static QuestionData generateQuestion() {
        var missedElementIndex = Randomizer.nextInt(PROGRESSION_LENGTH);
        var step = Randomizer.nextInt(PROGRESSION_CONSTANT_LIMIT);
        var firstValue = Randomizer.nextInt(PROGRESSION_CONSTANT_LIMIT);
        var progression = generateProgression(firstValue, step, PROGRESSION_LENGTH);
        return new QuestionData(
            generateProgressionString(progression, missedElementIndex),
            Integer.toString(progression[missedElementIndex])
        );
    }

    @Deprecated
    public static boolean runLoop() {
        var missedElementIndex = Randomizer.nextInt(PROGRESSION_LENGTH);
        var step = Randomizer.nextInt(PROGRESSION_CONSTANT_LIMIT);
        var firstValue = Randomizer.nextInt(PROGRESSION_CONSTANT_LIMIT);
        var progression = generateProgression(firstValue, step, PROGRESSION_LENGTH);

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

    private static int[] generateProgression(int firstValue, int step, int progressionLength) {
        var result = new int[progressionLength];
        var currentElement = firstValue;

        for (int i = 0; i < progressionLength; i++) {
            result[i] = currentElement;
            currentElement += step;
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
