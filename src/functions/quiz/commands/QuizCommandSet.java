package functions.quiz.commands;

import core.set.CommandSet;

import java.util.HashMap;

public class QuizCommandSet extends CommandSet
{
    public QuizCommandSet()
    {
        super(0,11,"/");
        add(new ExitQuizCommand());
        add(new NextQuizCommand());
    }
}
