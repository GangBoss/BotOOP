package functions.anonymous.commands;

import core.CommandBase;
import core.User;
import functions.anonymous.Anonymous;

public class ExitAnonymousCommand extends CommandBase<Anonymous>
{
    public ExitAnonymousCommand()
    {
        super("Exit from anonymous");
    }

    @Override
    public void execute(Anonymous anonymous, User user)
    {
        anonymous.stop(user);
    }
}



