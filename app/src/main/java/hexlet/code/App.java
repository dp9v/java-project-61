package hexlet.code;

import hexlet.code.common.Cli;
import hexlet.code.common.ConsoleReader;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import static hexlet.code.common.Constants.CALC_NUMBER;
import static hexlet.code.common.Constants.EVEN_NUMBER;
import static hexlet.code.common.Constants.EXIT_NUMBER;
import static hexlet.code.common.Constants.GCD_NUMBER;
import static hexlet.code.common.Constants.GREET_NUMBER;
import static hexlet.code.common.Constants.OPTIONS;
import static hexlet.code.common.Constants.PRIME_NUMBER;
import static hexlet.code.common.Constants.PROGRESSION_NUMBER;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        printOptions();
        System.out.print("Your choice: ");
        var option = ConsoleReader.nextNumber();

        switch (option) {
            case EXIT_NUMBER:
                System.out.println("\nWelcome to the Brain Games!");
                break;
            case GREET_NUMBER:
                System.out.println("\nWelcome to the Brain Games!");
                Cli.greet();
                break;
            default:
                runGame(option);
        }
    }

    public static void printOptions() {
        for (int i = 1; i < OPTIONS.length; i++) {
            System.out.printf("%d - %s\n", i, OPTIONS[i]);
        }
        System.out.printf("%d - %s\n", EXIT_NUMBER, OPTIONS[EXIT_NUMBER]);
    }

    private static void runGame(int option) {
        switch (option) {
            case EVEN_NUMBER -> Even.run();
            case CALC_NUMBER -> Calc.run();
            case GCD_NUMBER -> Gcd.run();
            case PROGRESSION_NUMBER -> Progression.run();
            case PRIME_NUMBER -> Prime.run();
            default -> throw new RuntimeException("Unknown option: " + option);
        }

    }
}
