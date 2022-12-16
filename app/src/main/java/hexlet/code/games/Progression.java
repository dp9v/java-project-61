package hexlet.code.games;

import hexlet.code.common.Randomizer;
import hexlet.code.common.GameEngine;

import static hexlet.code.common.Constants.DEFAULT_QUESTIONS_COUNT;

public class Progression {
    private static final String INTRO = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int PROGRESSION_CONSTANT_LIMIT = 10;

    public static void run() {
        GameEngine.run(INTRO, generateQuestions());
    }

    private static String[][] generateQuestions() {
        var generatedQuestions = new String[DEFAULT_QUESTIONS_COUNT][];
        for (int i = 0; i < DEFAULT_QUESTIONS_COUNT; i++) {
            generatedQuestions[i] = generateQuestion();
        }
        return generatedQuestions;
    }

    private static String[] generateQuestion() {
        var missedElementIndex = Randomizer.nextInt(PROGRESSION_LENGTH);
        var step = Randomizer.nextInt(PROGRESSION_CONSTANT_LIMIT);
        var firstValue = Randomizer.nextInt(PROGRESSION_CONSTANT_LIMIT);
        var progression = generateProgression(firstValue, step, PROGRESSION_LENGTH);
        return new String[]{
            generateProgressionQuestionText(progression, missedElementIndex),
            Integer.toString(progression[missedElementIndex])
        };
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

    private static String generateProgressionQuestionText(int[] progression, int missedElementIndex) {
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
