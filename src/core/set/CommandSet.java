package core.set;

import core.CommandBase;
import data.botCommands.ListCommand;

import java.util.HashMap;

public class CommandSet extends BasicSet<String, CommandBase>
{
    private int prefixCount;
    private int suffixLength;
    private String commandPrefix;

    private String commandList = "";

    public CommandSet(int prefixCount, int suffixLength, String commandPrefix){
        set = new HashMap<>();
        this.commandPrefix = commandPrefix;
        add(new ListCommand(this), "command".length());
        this.prefixCount = prefixCount;
        this.suffixLength = suffixLength;
    }

    @Override
    protected void add(CommandBase item)
    {
        add(item, suffixLength);
    }

    private void add(CommandBase item, int suffixLength)
    {
        var result = new StringBuilder(commandList);
        var name = item.getClass().getSimpleName().toLowerCase();
        name = commandPrefix + name.substring(prefixCount, name.length() - suffixLength);
        result.append(String.format("%s\t-\t%s\n",name,item.info ));
        commandList = result.toString();
        set.put(name, item);
    }

    public String getCommandList(){
        return commandList;
    }
}
