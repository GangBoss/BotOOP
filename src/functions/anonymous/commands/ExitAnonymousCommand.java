package functions.anonymous.commands;

import core.CommandBase;
import core.Message;
import core.User;
import functions.anonymous.Anonymous;

public class ExitAnonymousCommand extends CommandBase<Anonymous>
{
    ExitAnonymousCommand()
    {
        super("Exit from anonymous");
    }

    @Override
    public void execute(Anonymous anonymous, Message message)
    {
        anonymous.stop(message.getUser());
    }
}



