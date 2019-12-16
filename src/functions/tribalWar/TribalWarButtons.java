package functions.tribalWar;

import core.ButtonsProvider;
import core.DataBase;

import java.util.Arrays;
import java.util.HashMap;


class TribalWarButtons extends ButtonsProvider<TribalWarState, TribalWarData>
{
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
}
