package functions.anonymous;

import core.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class AnonymousButtons
{
    private HashMap<AnonymousState, List<String>> buttons;
    private AnonymousDataBase dataBase;

    public AnonymousButtons(AnonymousDataBase dataBase)
    {
        this.dataBase = dataBase;
        buttons = new HashMap<>()
        {{
            put(AnonymousState.InPair, Arrays.asList(new String[]
                    {
                            "/exit",
                            "/searching",
                            "/abandonchat"
                    }));
            put(AnonymousState.Menu, Arrays.asList(new String[]
                    {
                            "/search",
                            "/exit",
                            "/searching"
                    }));
            put(AnonymousState.Searching, Arrays.asList(new String[]
                    {"/searching",
                            "/abandonchat",
                            "/exit"
                    }));
        }};

    }

    List<String> getButtons(User user)
    {
        if (!buttons.containsKey(dataBase.states.get(user)))
            return new ArrayList<>();

        return buttons.get(dataBase.states.get(user));
    }
}

