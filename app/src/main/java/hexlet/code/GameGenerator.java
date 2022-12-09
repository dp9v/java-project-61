package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GameData;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.QuestionData;
import hexlet.code.utils.Constants;

import static hexlet.code.utils.Constants.CALC_NUMBER;
import static hexlet.code.utils.Constants.EVEN_NUMBER;
import static hexlet.code.utils.Constants.GCD_NUMBER;
import static hexlet.code.utils.Constants.PRIME_NUMBER;
import static hexlet.code.utils.Constants.PROGRESSION_NUMBER;

public class GameGenerator {
    private static final String[] GAME_DESCRIPTIONS = {
        null, null,
        "Answer 'yes' if the number is even, otherwise answer 'no'.",
        "What is the result of the expression?",
        "Find the greatest common divisor of given numbers.",
        "What number is missing in the progression?",
        "Answer 'yes' if given number is prime. Otherwise answer 'no'."
    };

    public static GameData generateGame(int option) {
        var questions = new QuestionData[Constants.DEFAULT_QUESTIONS_COUNT];
        for (int i = 0; i < Constants.DEFAULT_QUESTIONS_COUNT; i++) {
            questions[i] = generateQuestion(option);
        }
        return new GameData(GAME_DESCRIPTIONS[option], questions);
    }

    private static QuestionData generateQuestion(int option) {
        return switch (option) {
            case EVEN_NUMBER -> Even.generateQuestion();
            case CALC_NUMBER -> Calc.generateQuestion();
            case GCD_NUMBER -> Gcd.generateQuestion();
            case PROGRESSION_NUMBER -> Progression.generateQuestion();
            case PRIME_NUMBER -> Prime.generateQuestion();
            default -> throw new RuntimeException();
        };
    }
}
