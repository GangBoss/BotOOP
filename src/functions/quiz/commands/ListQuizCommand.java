package functions.quiz.commands;

import data.botCommands.ListCommand;

public class ListQuizCommand extends ListCommand
{
    public ListQuizCommand(QuizCommandSet commands)
    {
        super(commands);
        this.info = "Print all commands";
    }
}
