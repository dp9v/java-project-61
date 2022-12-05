package hexlet.code;

import hexlet.code.utils.ConsoleReader;

import static hexlet.code.utils.Constants.EXIT_NUMBER;
import static hexlet.code.utils.Constants.OPTIONS;

public class App {


    public static void main(String[] args) {
        var option = selectOption();
        System.out.println("\nWelcome to the Brain Games!");

        if (option == EXIT_NUMBER) {
            return;
        }

        var userName = greet();

        if (option >= OPTIONS.length) {
            return;
        }
        GameEngine.runGame(userName, option);
    }

    public static String greet() {
        System.out.print("May I have your name? ");
        var userName = ConsoleReader.nextLine();
        System.out.printf("Hello, %s!\n", userName);
        return userName;
    }

    public static int selectOption() {
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < OPTIONS.length; i++) {
            System.out.printf("%d - %s\n", i, OPTIONS[i]);
        }
        System.out.printf("%d - %s\n", EXIT_NUMBER, OPTIONS[EXIT_NUMBER]);
        System.out.print("Your choice: ");
        return ConsoleReader.nextNumber();
    }
}
