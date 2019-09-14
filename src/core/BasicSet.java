package core;

import data.commands.CommandBase;
import data.commands.ExitCommand;
import data.commands.ListCommand;
import data.commands.QuizCommand;

import java.util.Collection;
import java.util.HashMap;

public abstract class BasicSet<T>
{
    protected HashMap<String, T> set = new HashMap<String, T>();
    protected int prefixCount;
    protected int suffixCount;

    protected void add(T item)
    {
        Class<?> enclosingClass = item.getClass().getEnclosingClass();
        String name;
        if (enclosingClass != null)
            name = enclosingClass.getSimpleName().toLowerCase();
        else name = item.getClass().getSimpleName().toLowerCase();
        name = name.substring(prefixCount, name.length() - suffixCount);
        set.put(name,item);
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
