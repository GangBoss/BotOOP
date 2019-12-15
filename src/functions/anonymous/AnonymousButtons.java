package functions.anonymous;

import core.DataBase;
import core.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class AnonymousButtons
{
    private HashMap<AnonymousState, List<String>> buttons;
    private DataBase<AnonymousState> dataBase;

    AnonymousButtons(DataBase<AnonymousState> dataBase)
    {
        this.dataBase = dataBase;
        buttons = new HashMap<>()
        {{
            put(AnonymousState.InPair, Arrays.asList(
                    "/exit",
                    "/searching",
                    "/abandonchat"
            ));
            put(AnonymousState.Menu, Arrays.asList(
                    "/search",
                    "/exit",
                    "/searching"
            ));
            put(AnonymousState.Searching, Arrays.asList("/searching",
                    "/abandonchat",
                    "/exit"
            ));
        }};

    }

    List<String> getButtons(User user)
    {
        if (!buttons.containsKey(dataBase.get(user)))
            return new ArrayList<>();

        return buttons.get(dataBase.get(user));
    }
}

