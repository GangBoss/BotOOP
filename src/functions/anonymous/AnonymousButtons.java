package functions.anonymous;

import core.User;

import java.util.ArrayList;
import java.util.HashMap;

class AnonymousButtons
{
    private HashMap<AnonymousState, ArrayList<String>> buttons;

    AnonymousButtons()
    {
        buttons = new HashMap<>()
        {{
            put(AnonymousState.InPair, new ArrayList<>()
            {{
                add("/exit");
                add("/searching");
                add("/abandonchat");
            }});
            put(AnonymousState.Menu, new ArrayList<>()
            {{
                add("/search");
                add("/exit");
                add("/searching");
            }});
            put(AnonymousState.Searching, new ArrayList<>()
            {{

                add("/searching");
                add("/abandonchat");
                add("/exit");
            }});
        }};

    }

    ArrayList<String> getButtons(User user)
    {
        if (!buttons.containsKey(AnonymousDataBase.states.get(user)))
            return new ArrayList<>();

        return buttons.get(AnonymousDataBase.states.get(user));
    }
}

