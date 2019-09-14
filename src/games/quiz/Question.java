package games.quiz;

import java.util.Objects;

public class Question
{
    public String question;
    public int id;
    private String answer;

    public Question(int id, String question, String answer)
    {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public boolean check(String userAnswer)
    {
        return Objects.equals(userAnswer, answer);
    }
}
