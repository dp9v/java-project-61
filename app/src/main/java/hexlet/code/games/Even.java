package hexlet.code.games;

import hexlet.code.utils.ConsoleReader;
import hexlet.code.utils.Constants;
import hexlet.code.utils.Randomizer;

import static hexlet.code.utils.Constants.DEFAULT_LIMIT;

public class Even {
    public static QuestionData generateQuestion() {
        var number = Randomizer.nextInt(DEFAULT_LIMIT);
        return new QuestionData(
            Integer.toString(number),
            isEven(number) ? "yes" : "no"
        );
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
