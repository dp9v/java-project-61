package hexlet.code;

import hexlet.code.common.ConsoleReader;

import static hexlet.code.common.Constants.EXIT_NUMBER;
import static hexlet.code.common.Constants.OPTIONS;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        printOptions();
        System.out.print("Your choice: ");
        var option = ConsoleReader.nextNumber();

        GameStarter.startGame(option);
    }

    public static void printOptions() {
        for (int i = 1; i < OPTIONS.length; i++) {
            System.out.printf("%d - %s\n", i, OPTIONS[i]);
        }
        System.out.printf("%d - %s\n", EXIT_NUMBER, OPTIONS[EXIT_NUMBER]);
    }
}
