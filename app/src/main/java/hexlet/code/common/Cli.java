package hexlet.code.common;

public class Cli {
    public static String greet() {
        System.out.print("May I have your name? ");
        var userName = ConsoleReader.nextLine();
        System.out.printf("Hello, %s!\n", userName);
        return userName;
    }
}
