package core;

import java.util.Collection;
import java.util.Map;

public abstract class BasicSet<T, V extends Map<String, T>>
{
    protected V set;
    protected int prefixCount = 0;
    protected int suffixCount = 0;
    protected String commandPrefix = "";

    public int getPrefixCount()
    {
        return prefixCount;
    }

    public int getSuffixCount()
    {
        return suffixCount;
    }

    public String getCommandPrefix(){
        return commandPrefix;
    }

    protected void add(T item)
    {
        Class<?> enclosingClass = item.getClass().getEnclosingClass();
        String name;
        if (enclosingClass != null)
            name = enclosingClass.getSimpleName().toLowerCase();
        else name = item.getClass().getSimpleName().toLowerCase();
        name = name.substring(prefixCount, name.length() - suffixCount);
        set.put(name, item);
    }

    public T find(String name)
    {
        return set.getOrDefault(name, null);
    }

    public boolean hasCommand(String name)
    {
        return set.containsKey(name);
    }

    public Collection<T> getAll()
    {
        return set.values();
    }
}
