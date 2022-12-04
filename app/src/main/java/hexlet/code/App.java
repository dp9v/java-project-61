package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;

import static hexlet.code.Constants.CALC_NUMBER;
import static hexlet.code.Constants.EVEN_NUMBER;
import static hexlet.code.Constants.EXIT_NUMBER;
import static hexlet.code.Constants.GCD_NUMBER;

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
            case CALC_NUMBER:
                Calc.run(userName);
                break;
            case GCD_NUMBER:
                Gcd.run(userName);
                break;
            default:
                return;
        }
    }
}
