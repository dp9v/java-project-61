package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

import static hexlet.code.Constants.*;

public class App {


    public static void main(String[] args) {
        var number = Cli.selectNumber();
        System.out.println("\nWelcome to the Brain Games!");
        runOption(number);
    }

    private static void runOption(int option) {
        if (option == EXIT_NUMBER) {
            return;
        }

        var userName = Cli.greet();

        switch (option) {
            case EVEN_NUMBER:
                Even.run(userName);
                break;
        }
    }
}
