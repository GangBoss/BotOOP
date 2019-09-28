package core.set;

public class StringSet<T> extends BasicSet<String, T>
{
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

    public String getCommandPrefix()
    {
        return commandPrefix;
    }

    @Override
    protected void add(T item)
    {
        Class<?> enclosingClass = item.getClass().getEnclosingClass();
        String name;
        if (enclosingClass != null)
            name = enclosingClass.getSimpleName().toLowerCase();
        else name = item.getClass().getSimpleName().toLowerCase();
        name = commandPrefix + name.substring(prefixCount, name.length() - suffixCount);
        set.put(name, item);
    }
}
