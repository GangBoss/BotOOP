package games.quiz.commands;

import core.CommandBase;
import core.set.StringSet;

import java.util.HashMap;

public class QuizCommandSet extends StringSet<CommandBase>
{
    public QuizCommandSet()
    {
        set = new HashMap<>();
        suffixCount = 11;
        commandPrefix = "/";

        add(new ExitQuizCommand());
        add(new NextQuizCommand());
        add(new ListQuizCommand(this));
    }
}
