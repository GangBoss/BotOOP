package games;

import core.BasicSet;
import core.Bot;
import games.quiz.Quiz;

import java.util.HashMap;

public class GameSet extends BasicSet<BaseGame, HashMap<String, BaseGame>>
{
    public GameSet(Bot bot) throws Exception
    {
        set = new HashMap<>();
        prefixCount = 0;
        suffixCount = 0;
        add(new Quiz(bot));
    }
}

