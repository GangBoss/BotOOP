package games;

import core.Bot;
import core.set.StringSet;
import games.anonymous.Anonymous;
import games.quiz.Quiz;

import java.util.HashMap;

public class GameSet extends StringSet<BaseGame>
{
    public GameSet(Bot bot) throws Exception
    {
        set = new HashMap<>();
        prefixCount = 0;
        suffixCount = 0;

        add(new Quiz(bot));
        add(new Anonymous(bot));
    }
}

