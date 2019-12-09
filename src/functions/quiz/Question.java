package functions.quiz;

import core.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question
{
    String question;
    public int id;
    private String answer;
    public List<String> questionKeys;

    String getAnswer()
    {
        return answer;
    }

    Question(int id, String question, String answer)
    {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    boolean isCorrect(Message userAnswer)
    {
        return Objects.equals(userAnswer.text.toLowerCase(), answer);
    }
}
