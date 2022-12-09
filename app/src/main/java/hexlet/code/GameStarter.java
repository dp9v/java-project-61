package hexlet.code;

import hexlet.code.common.ConsoleReader;
import hexlet.code.engine.GameEngine;

import static hexlet.code.common.Constants.EXIT_NUMBER;
import static hexlet.code.common.Constants.GREET_NUMBER;

public class GameStarter {
    public static void startGame(int option) {
        System.out.println("\nWelcome to the Brain Games!");

        if (option == EXIT_NUMBER) {
            return;
        }

        System.out.print("May I have your name? ");
        var userName = ConsoleReader.nextLine();
        System.out.printf("Hello, %s!\n", userName);

        if (option == GREET_NUMBER) {
            return;
        }

        GameEngine.runGame(
            GameGenerator.generateGame(option),
            userName
        );
    }
}
