package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GameData;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.QuestionData;
import hexlet.code.utils.ConsoleReader;

import static hexlet.code.utils.Constants.CALC_NUMBER;
import static hexlet.code.utils.Constants.EVEN_NUMBER;
import static hexlet.code.utils.Constants.GCD_NUMBER;
import static hexlet.code.utils.Constants.PRIME_NUMBER;
import static hexlet.code.utils.Constants.PROGRESSION_NUMBER;

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

    public static void runGame(String userName, int option) {
        GameData gameData = generateGame(option);
        runGame(gameData, userName);
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

    private static boolean runGameLoop(int option) {
        return switch (option) {
            case EVEN_NUMBER -> Even.runLoop();
            case CALC_NUMBER -> Calc.runLoop();
            case GCD_NUMBER -> Gcd.runLoop();
            case PROGRESSION_NUMBER -> Progression.runLoop();
            case PRIME_NUMBER -> Prime.runLoop();
            default -> false;
        };
    }

    private static GameData generateGame(int option) {
        return switch (option) {
            case EVEN_NUMBER -> Even.generateGame();
            case CALC_NUMBER -> Calc.generateGame();
            case GCD_NUMBER -> Gcd.generateGame();
            case PROGRESSION_NUMBER -> Progression.generateGame();
            case PRIME_NUMBER -> Prime.generateGame();
            default -> throw new RuntimeException();
        };
    }
}
