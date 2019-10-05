package core;

import functions.FunctionType;

public class User<T>
{
    public FunctionType state;
    private Id<T> id;

    public Id<T> getFullId(){
        return id;
    }

    public T getId()
    {
        return id.getId();
    }

    public PlatformType getUserPlatform(){
        return id.getUserPlatform();
    }

    public User(T id, PlatformType userPlatform)
    {
        this.id = new Id<>(id, userPlatform);
        state = FunctionType.None;
    }

    public User(Id<T> id)
    {
        this.id = id;
        state = FunctionType.None;
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof User)
        {
            var other = (User<?>) obj;
            return id.equals(other.id);
        }
        return false;
    }
}
