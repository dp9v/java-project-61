package hexlet.code.utils;

import java.util.Scanner;

public class ConsoleReader {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String nextLine() {
        return SCANNER.nextLine();
    }

    public static int nextNumber() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
