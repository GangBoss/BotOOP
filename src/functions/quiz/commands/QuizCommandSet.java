package functions.quiz.commands;

import core.set.CommandSet;

import java.util.HashMap;

public class QuizCommandSet extends CommandSet
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
