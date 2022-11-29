package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greet() {
        System.out.print("May I have your name? ");
        var userName = new Scanner(System.in).nextLine();
        System.out.printf("Hello, %s!", userName);
    }
}
