package functions.anonymous;

import core.ButtonsProvider;
import core.DataBase;

import java.util.Arrays;
import java.util.HashMap;

class AnonymousButtons extends ButtonsProvider<AnonymousState, AnonymousState>
{
    AnonymousButtons(DataBase<AnonymousState> dataBase)
    {
        this.dataBase = dataBase;
        buttons = new HashMap<>()
        {{
            put(AnonymousState.InPair, Arrays.asList(
                    "/exit",
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
}

