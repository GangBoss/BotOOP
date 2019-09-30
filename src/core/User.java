package core;

import functions.FunctionType;

public class User<T>
{
    private T id;
    public FunctionType state;
    private PlatformType userPlatform;

    public T getId(){
        return id;
    }

    public PlatformType getUserPlatform(){
        return userPlatform;
    }

    public User(T id, PlatformType userPlatform)
    {
        this.id = id;
        this.userPlatform = userPlatform;
        state = FunctionType.None;
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
