package functions.tribalWar;

import core.DataBase;
import core.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class TribalWarButtons
{
    private final HashMap<TribalWarState, List<String>> buttons;
    private DataBase<TribalWarData> dataBase;

    TribalWarButtons(DataBase<TribalWarData> dataBase)
    {
        this.dataBase = dataBase;
        buttons = new HashMap<>()
        {{
            put(TribalWarState.Playing, Arrays.asList(
                    "/chop 1",
                    "/hunt 1",
                    "/getInformation",
                    "/exit"
            ));
        }};
    }

    List<String> getButtons(User user)
    {
        var userState = dataBase.get(user).state;
        if (!buttons.containsKey(userState))
            return new ArrayList<>();
        return buttons.get(userState);

    }
}
