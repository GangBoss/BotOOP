package games.quiz.commands;

import data.botCommands.BotCommandSet;
import data.botCommands.ListCommand;

public class ListQuizCommand extends ListCommand
{
    public ListQuizCommand(QuizCommandSet commands)
    {
        super(commands);
        this.info = "Print all commands";
    }
}
