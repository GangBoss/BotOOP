package games;

import core.BasicSet;
import core.Bot;
import games.quiz.Quiz;

public class GameSet extends BasicSet<BaseGame>
{
    public GameSet(Bot bot) throws Exception
    {
        prefixCount = 0;
        suffixCount = 0;
        add(new Quiz(bot));
    }
}

