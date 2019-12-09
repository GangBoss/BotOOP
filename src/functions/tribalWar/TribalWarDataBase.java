package functions.tribalWar;
import core.User;
import java.util.HashMap;

public class TribalWarDataBase
{
    HashMap<User, TribalWarData> data = new HashMap<>();

    void ChangeState(User user, TribalWarState quizState)
    {
        var currentData = data.get(user);
        currentData.state = quizState;
    }

    public TribalWarData get(User user)
    {
        return data.get(user);
    }

    public boolean containsKey(User user)
    {
        return data.containsKey(user);
    }

    public void put(User user, TribalWarData tribalWarData)
    {
        data.put(user, tribalWarData);
    }

    public int count()
    {
        return data.size();
    }
}
