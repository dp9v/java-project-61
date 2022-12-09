package hexlet.code.games;

public class QuestionData {
    private final String question;
    private final String expectedAnswer;

    public QuestionData(String question, String expectedAnswer) {
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public String getQuestion() {
        return question;
    }
}
