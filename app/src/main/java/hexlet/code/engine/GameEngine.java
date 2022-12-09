package hexlet.code.engine;

import hexlet.code.common.ConsoleReader;

public class GameEngine {
    private static final String FAIL_TEMPLATE = "Let's try again, %s!\n";
    private static final String CONGRATULATIONS_TEMPLATE = "Congratulations, %s!\n";
    private static final String QUESTION_TEMPLATE = "Question: %s\n";
    private static final String WRONG_ANSWER_TEMPLATE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n";

    public static void runGame(GameData gameData, String userName) {
        System.out.println(gameData.getIntroduction());
        for (QuestionData question : gameData.getQuestions()) {
            var answerIsCorrect = askQuestion(question);
            if (!answerIsCorrect) {
                System.out.printf(FAIL_TEMPLATE, userName);
                return;
            }
        }
        System.out.printf(CONGRATULATIONS_TEMPLATE, userName);
    }

    public static boolean askQuestion(QuestionData questionData) {
        System.out.printf(QUESTION_TEMPLATE, questionData.getQuestion());
        System.out.print("Your answer: ");
        var answer = ConsoleReader.nextLine();

        if (answer.equals(questionData.getExpectedAnswer())) {
            System.out.println("Correct!");
            return true;
        }

        System.out.printf(WRONG_ANSWER_TEMPLATE, answer, questionData.getExpectedAnswer());
        return false;
    }
}
