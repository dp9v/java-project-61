package hexlet.code.games;

import hexlet.code.common.Randomizer;
import hexlet.code.engine.QuestionData;

import static hexlet.code.common.Constants.DEFAULT_LIMIT;

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
