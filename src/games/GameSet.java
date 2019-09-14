package games;

import core.Bot;
import games.quiz.Quiz;

import java.util.Collection;
import java.util.HashMap;

public class GameSet
{
    private HashMap<String, BaseGame> games = new HashMap<>();

    public GameSet(Bot bot) throws Exception
    {
        add(new Quiz(bot));
    }

    private void add(BaseGame game)
    {
        Class<?> enclosingClass = game.getClass().getEnclosingClass();
        if (enclosingClass != null)
            games.put(enclosingClass.getSimpleName().toLowerCase(), game);
        else games.put(game.getClass().getSimpleName().toLowerCase(), game);
    }

    public BaseGame find(String name)
    {
        return games.getOrDefault(name, null);
    }

    public boolean hasCommand(String name)
    {
        return games.containsKey(name);
    }

    public Collection<BaseGame> getAll()
    {
        return games.values();
    }
}

