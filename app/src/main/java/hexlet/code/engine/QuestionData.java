package hexlet.code.engine;

public final class QuestionData {
    private final String question;
    private final String expectedAnswer;

    public QuestionData(String questionValue, String expectedAnswerValue) {
        this.question = questionValue;
        this.expectedAnswer = expectedAnswerValue;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public String getQuestion() {
        return question;
    }
}
