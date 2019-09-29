package core.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
}
