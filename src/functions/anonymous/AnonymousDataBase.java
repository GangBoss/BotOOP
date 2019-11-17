package functions.anonymous;

import core.User;

import java.util.HashMap;

abstract class AnonymousDataBase
{
    static HashMap<User, AnonymousState> states=new HashMap<>();
}
