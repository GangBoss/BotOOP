package games.quiz.commands;

import core.BasicSet;
import core.CommandBase;
import games.quiz.commands.ExitQuizCommand;

import java.util.HashMap;

public class QuizCommandSet extends BasicSet<CommandBase, HashMap<String, CommandBase>>
{
    public QuizCommandSet()
    {
        set = new HashMap<>();
        suffixCount = 7;
        add(new ExitQuizCommand());
        add(new NextCommand());
    }
}
