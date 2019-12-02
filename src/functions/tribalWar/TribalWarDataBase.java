package functions.tribalWar;

import core.User;

import java.util.Collection;
import java.util.HashMap;

public class TribalWarDataBase
{
    static HashMap<User, TribalWarData> data = new HashMap<>();

    static void ChangeState(User user, TribalWarState quizState)
    {
        var currentData = data.get(user);
        currentData.state = quizState;
    }

    public static TribalWarData get(User user)
    {
        return data.get(user);
    }

    public static boolean containsKey(User user)
    {
        return data.containsKey(user);
    }

    public static void put(User user, TribalWarData tribalWarData)
    {
        data.put(user, tribalWarData);
    }

    public static int count()
    {
        return data.size();
    }
}
