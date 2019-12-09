package functions.quiz;

import core.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class QuizButtons
{
    private HashMap<QuizState, List<String>> buttons;

    QuizDataBase dataBase;

    QuizButtons(QuizDataBase dataBase)
    {
        this.dataBase = dataBase;
        buttons = new HashMap<>()
        {{
            put(QuizState.Quiz, Arrays.asList(new String[]{
                    "/next",
                    "/list",
                    "/exit"
            }));
            put(QuizState.MainMenu, Arrays.asList(new String[]{
                    "/list",
                    "/exit"
            }));
        }};

    }

    List<String> getButtons(User user)
    {
        if (!buttons.containsKey(dataBase.quizData.get(user).state))
            return new ArrayList<>();

        return buttons.get(dataBase.quizData.get(user).state);
    }
}
