package hexlet.code.common;

public class GameEngine {
    private static final String FAIL_TEMPLATE = "Let's try again, %s!\n";
    private static final String CONGRATULATIONS_TEMPLATE = "Congratulations, %s!\n";
    private static final String QUESTION_TEMPLATE = "Question: %s\n";
    private static final String WRONG_ANSWER_TEMPLATE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n";

    public static void run(
        String introductionText,
        String[][] questionsData
    ) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var userName = ConsoleReader.nextLine();
        System.out.printf("Hello, %s!\n", userName);

        System.out.println(introductionText);

        for (String[] questionData : questionsData) {
            System.out.printf(QUESTION_TEMPLATE, questionData[0]);
            System.out.print("Your answer: ");
            var answer = ConsoleReader.nextLine();
            if (!answer.equals(questionData[1])) {
                System.out.printf(WRONG_ANSWER_TEMPLATE, answer, questionData[1]);
                System.out.printf(FAIL_TEMPLATE, userName);
                return;
            }
            System.out.println("Correct!");
        }
        System.out.printf(CONGRATULATIONS_TEMPLATE, userName);
    }
}
