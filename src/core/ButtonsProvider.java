package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  abstract  class ButtonsProvider<State, Data extends Statable<State>>
{
    protected DataBase<Data> dataBase;
    protected HashMap<State, List<String>> buttons;
    public List<String> getButtons(User user)
    {
        if (!buttons.containsKey(dataBase.get(user).getState()))
            return new ArrayList<>();

        return buttons.get(dataBase.get(user).getState());
    }
}
