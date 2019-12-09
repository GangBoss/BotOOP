package functions.anonymous;

import core.User;

import java.util.HashMap;

public class AnonymousDataBase
{
    public  HashMap<User, AnonymousState> states;
    public  AnonymousDataBase(){
        states=new HashMap<>();
    }
}
