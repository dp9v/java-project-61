package hexlet.code.engine;

public final class GameData {
    private final String introduction;
    private final QuestionData[] questions;

    public GameData(String introduction, QuestionData[] questions) {
        this.introduction = introduction;
        this.questions = questions;
    }

    public String getIntroduction() {
        return introduction;
    }

    public QuestionData[] getQuestions() {
        return questions;
    }
}
