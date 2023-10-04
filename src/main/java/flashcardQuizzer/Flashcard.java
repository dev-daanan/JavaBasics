package flashcardQuizzer;

public class Flashcard {
    String question;
    String answer;
    boolean answeredCorrectly = false;

    public Flashcard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public Flashcard(String onlyOneParam) {
        this("", "");
    }

    public Flashcard() {
        this("", "");
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                " question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                " }";
    }
}
