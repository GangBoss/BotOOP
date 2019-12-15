package core.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Stream<T> getAll()
    {
        return set.values().stream();
    }
}

