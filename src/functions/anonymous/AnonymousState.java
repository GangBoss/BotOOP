package functions.anonymous;

import core.Statable;

public enum AnonymousState implements Statable<AnonymousState>
{
    Menu,
    Searching,
    InPair;

    @Override
    public AnonymousState getState()
    {
        return this;
    }
}
