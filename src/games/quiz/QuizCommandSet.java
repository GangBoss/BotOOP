package games.quiz;

import core.BasicSet;
import core.CommandBase;
import games.quiz.commands.ExitQuizCommand;

public class QuizCommandSet extends BasicSet<CommandBase>
{
    public QuizCommandSet()
    {
        suffixCount = 7;
        add(new ExitQuizCommand());
    }
}
