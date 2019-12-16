package functions.quiz;

import core.ButtonsProvider;
import core.DataBase;
import core.User;
import functions.anonymous.AnonymousState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class QuizButtons extends ButtonsProvider<QuizState, QuizData>
{
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
}
