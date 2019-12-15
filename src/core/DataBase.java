package core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class DataBase<T>
{
    private HashMap<User, T> data = new HashMap<>();

    public void update(User user, Consumer<T> action)
    {
        var currentData = data.get(user);
        action.accept(currentData);
    }

    public T get(User user)
    {
        return data.get(user);
    }

    public Stream<Map.Entry<User,T>> getAll()
    {
        return  data.entrySet().stream();
    }

    public boolean containsKey(User user)
    {
        return data.containsKey(user);
    }

    public void put(User user, T tribalWarData)
    {
        data.put(user, tribalWarData);
    }

    public int count()
    {
        return data.size();
    }

    public void remove(User user)
    {
        data.remove(user);
    }
}
