package functions.quiz;

import core.User;

import java.util.ArrayList;
import java.util.HashMap;

class QuizButtons
{
    private HashMap<QuizState, ArrayList<String>> buttons;

    QuizButtons()
    {
        buttons = new HashMap<>()
        {{
            put(QuizState.Quiz, new ArrayList<>()
            {{
                add("/next");
                add("/exit");
            }});
            put(QuizState.MainMenu, new ArrayList<>()
            {{
                add("/search");
                add("/exit");
            }});
        }};

    }

    ArrayList<String> getButtons(User user)
    {
        if (buttons.containsKey(QuizDataBase.quizData.get(user).state))
            return new ArrayList<>();

        return buttons.get(QuizDataBase.quizData.get(user).state);
    }
}
