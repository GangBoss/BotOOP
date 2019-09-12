import java.lang.reflect.Array;
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

    public Question(int id, String[] inp) throws IllegalArgumentException
    {
        if (inp.length < 2) throw new IllegalArgumentException("wrong count");
        new Question(id, inp[0], inp[1]);
    }

    public boolean check(String userAnswer)
    {
        return Objects.equals(userAnswer, answer);
    }
}
