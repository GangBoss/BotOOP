package games.quiz;

import java.util.Objects;

public class Question
{
    public String question;
    public int id;
    private String answer;

    public String getAnswer()
    {
        return answer;
    }

    public Question(int id, String question, String answer)
    {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public boolean isCorrect(String userAnswer)
    {
        return Objects.equals(userAnswer.toLowerCase(), answer);
    }
}
