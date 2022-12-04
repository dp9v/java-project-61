package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Constants.EXIT_NUMBER;
import static hexlet.code.Constants.OPTIONS;

public class Cli {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String greet() {
        System.out.print("May I have your name? ");
        var userName = nextLine();
        System.out.printf("Hello, %s!\n", userName);
        return userName;
    }

    public static int selectNumber() {
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < OPTIONS.length; i++) {
            System.out.printf("%d - %s\n", i, OPTIONS[i]);
        }
        System.out.printf("%d - %s\n", EXIT_NUMBER, OPTIONS[EXIT_NUMBER]);
        System.out.print("Your choice: ");
        return nextNumber();
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

    public static int nextNumber() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
