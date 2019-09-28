package core;

public class User<T>
{
    public T id;
    public String state;
    public PlatformType userPlatform;

    public User(T id, PlatformType userPlatform)
    {
        this.id = id;
        this.userPlatform = userPlatform;
    }

    @Override
    public int hashCode()
    {
        String builder = id.toString() + userPlatform.name().toLowerCase();
        return builder.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof User)
        {
            var other = (User<?>) obj;
            return other.id.equals(id) && other.userPlatform.equals(userPlatform);
        }
        return false;
    }
}
