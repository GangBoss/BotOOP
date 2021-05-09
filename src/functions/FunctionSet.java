package functions;

import core.BaseFunction;
import core.Bot;
import core.set.BasicSet;
import functions.anonymous.Anonymous;
import functions.quiz.Quiz;

import java.util.HashMap;

public class FunctionSet extends BasicSet<FunctionType, BaseFunction>
{
    public FunctionSet(Bot bot) throws Exception
    {
        set = new HashMap<>();

        add(new Quiz(bot));
        add(new Anonymous(bot));
    }

    @Override
    protected void add(BaseFunction item)
    {
        set.put(item.type, item);
    }
}

