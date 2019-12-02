package core.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class BasicSet<V, T>
{
    protected HashMap<V, T> set;

    protected abstract void add(T item);

    public T find(V name)
    {
        return set.getOrDefault(name, null);
    }

    public boolean hasItem(V key)
    {
        return set.containsKey(key);
    }

    public Collection<T> getAll()
    {
        return set.values();
    }
    //TODO Get all instancesOfAnInterface
    public List<T> getAllInterface(Function<T,Boolean> func)
    {
      return set.values().stream().filter(func::apply).collect(Collectors.toList());
    }
}

