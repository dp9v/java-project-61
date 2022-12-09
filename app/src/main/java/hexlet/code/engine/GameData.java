package hexlet.code.engine;

public final class GameData {
    private final String introduction;
    private final QuestionData[] questions;

    public GameData(String introductionValue, QuestionData[] questionsValue) {
        this.introduction = introductionValue;
        this.questions = questionsValue;
    }

    public String getIntroduction() {
        return introduction;
    }

    public QuestionData[] getQuestions() {
        return questions;
    }
}
