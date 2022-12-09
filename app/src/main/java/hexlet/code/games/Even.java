package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Constants;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Constants.DEFAULT_LIMIT;

public class Even {
    private static final String INTRO = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static GameData generateGame() {
        var questions = new QuestionData[Constants.DEFAULT_QUESTIONS_COUNT];
        for (int i = 0; i < Constants.DEFAULT_QUESTIONS_COUNT; i++) {
            questions[i] = generateQuestion();
        }
        return new GameData(INTRO, questions);
    }

    private static QuestionData generateQuestion() {
        var number = Randomizer.nextInt(DEFAULT_LIMIT);
        return new QuestionData(
            Integer.toString(number),
            isEven(number) ? "yes" : "no"
        );
    }

    @Deprecated
    public static boolean runLoop() {
        var number = Randomizer.nextInt(DEFAULT_LIMIT);
        String expectedAnswer = isEven(number) ? "yes" : "no";

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

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
