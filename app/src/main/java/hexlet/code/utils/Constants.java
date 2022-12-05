package hexlet.code.utils;

public class Constants {
    public static final int DEFAULT_LIMIT = 20;
    public static final int DEFAULT_LOOPS_COUNT = 3;

    public static final int EXIT_NUMBER = 0;
    public static final int EVEN_NUMBER = 2;
    public static final int CALC_NUMBER = 3;
    public static final int GCD_NUMBER = 4;
    public static final int PROGRESSION_NUMBER = 5;
    public static final int PRIME_NUMBER = 6;

    public static final String[] OPTIONS =
        {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};

    public static final String[] GAME_DESCRIPTIONS = {
        null, null,
        "Answer 'yes' if the number is even, otherwise answer 'no'.",
        "What is the result of the expression?",
        "Find the greatest common divisor of given numbers.",
        "What number is missing in the progression?",
        "Answer 'yes' if given number is prime. Otherwise answer 'no'."
    };
}
