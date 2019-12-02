package functions.tribalWar;

import core.User;

import java.util.ArrayList;
import java.util.HashMap;


class TribalWarButtons
{
    private final HashMap<TribalWarState, ArrayList<String>> buttons;

    TribalWarButtons()
    {
        buttons = new HashMap<>()
        {{
            put(TribalWarState.Playing, new ArrayList<>()
            {{
                add("/chop 1");
                add("/hunt 1");
                add("/getInformation");
                add("/exit");
            }});
        }};
    }

    ArrayList<String> getButtons(User user)
    {
        var userState = TribalWarDataBase.get(user).state;
        if (!buttons.containsKey(userState))
            return new ArrayList<>();
        return buttons.get(userState);

    }
}
