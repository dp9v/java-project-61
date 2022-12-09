package hexlet.code;

import hexlet.code.games.GameData;
import hexlet.code.games.QuestionData;
import hexlet.code.utils.ConsoleReader;

public class GameEngine {

    public static void runGame(GameData gameData, String userName) {
        System.out.println(gameData.getIntroduction());
        for (QuestionData question : gameData.getQuestions()) {
            var answerIsCorrect = askQuestion(question);
            if (!answerIsCorrect) {
                System.out.printf("Let's try again, %s!\n", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!\n", userName);
    }

    public static boolean askQuestion(QuestionData questionData) {

        System.out.printf("Question: %s\n", questionData.getQuestion());
        System.out.print("Your answer: ");
        var answer = ConsoleReader.nextLine();

        if (answer.equals(questionData.getExpectedAnswer())) {
            System.out.println("Correct!");
            return true;
        }

        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, questionData.getExpectedAnswer());
        return false;
    }
}
