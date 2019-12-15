package functions.quiz;

import core.DataBase;
import core.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class QuizButtons
{
    private HashMap<QuizState, List<String>> buttons;

    private DataBase<QuizData> dataBase;

    QuizButtons(DataBase<QuizData> dataBase)
    {
        this.dataBase = dataBase;
        buttons = new HashMap<>()
        {{
            put(QuizState.Quiz, Arrays.asList(
                    "/next",
                    "/list",
                    "/exit"
            ));
            put(QuizState.MainMenu, Arrays.asList(
                    "/list",
                    "/exit"
            ));
        }};

    }

    List<String> getButtons(User user)
    {
        if (!buttons.containsKey(dataBase.get(user).state))
            return new ArrayList<>();

        return buttons.get(dataBase.get(user).state);
    }
}
