package hexlet.code.games;

import hexlet.code.utils.Randomizer;

public class Prime {
    private static final int LIMIT = 1000;

    public static QuestionData generateQuestion() {
        var number = Randomizer.nextInt(LIMIT);
        var isPrime = isPrime(number);
        return new QuestionData(
            Integer.toString(number),
            isPrime ? "yes" : "no"
        );
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
