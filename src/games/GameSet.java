package games;

import core.Bot;
import core.set.BasicSet;
import games.anonymous.Anonymous;
import games.quiz.Quiz;

import java.util.HashMap;

public class GameSet extends BasicSet<GameType, BaseGame>
{
    public GameSet(Bot bot) throws Exception
    {
        set = new HashMap<>();

        add(new Quiz(bot));
        add(new Anonymous(bot));
    }

    @Override
    protected void add(BaseGame item)
    {
        set.put(item.type, item);
    }
}

