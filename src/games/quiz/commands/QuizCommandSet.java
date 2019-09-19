package games.quiz.commands;

import core.BasicSet;
import core.CommandBase;

import java.util.HashMap;

public class QuizCommandSet extends BasicSet<CommandBase, HashMap<String, CommandBase>>
{
    public QuizCommandSet()
    {
        set = new HashMap<>();
        suffixCount = 11;

        add(new ExitQuizCommand());
        add(new NextQuizCommand());
    }
}
