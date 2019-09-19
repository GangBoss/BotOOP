package core;

public class User<T extends Comparable>
{
    public T id;
    public String state;
    public String userPlatform;
    public int wa;

    public User(T id, String userPlatform)
    {
        this.id = id;
        this.userPlatform = userPlatform;
        wa=0;
    }

    @Override
    public int hashCode()
    {
        String builder = id.toString() + userPlatform.toLowerCase();
        return builder.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof User<?>)
        {
            var other = (User<?>) obj;
            return other.id.compareTo(id) == 0 && other.userPlatform.equals(userPlatform);
        }
        return false;
    }
}
