package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import static hexlet.code.utils.Constants.CALC_NUMBER;
import static hexlet.code.utils.Constants.EVEN_NUMBER;
import static hexlet.code.utils.Constants.GAME_DESCRIPTIONS;
import static hexlet.code.utils.Constants.GCD_NUMBER;
import static hexlet.code.utils.Constants.DEFAULT_LOOPS_COUNT;
import static hexlet.code.utils.Constants.PRIME_NUMBER;
import static hexlet.code.utils.Constants.PROGRESSION_NUMBER;

public class GameEngine {

    public static void runGame(String userName, int option) {
        System.out.println(GAME_DESCRIPTIONS[option]);
        for (int i = 0; i < DEFAULT_LOOPS_COUNT; i++) {
            var result = runGameLoop(option);
            if (!result) {
                System.out.printf("Let's try again, %s!\n", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!\n", userName);
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
}
