package core.set;

import core.CommandBase;
import data.botCommands.ListCommand;

import java.util.HashMap;

public class CommandSet extends BasicSet<String, CommandBase>
{
    private int prefixCount;
    private int suffixCount;
    private String commandPrefix;

    private String commandList = "";

    public CommandSet(int prefixCount, int suffixCount, String commandPrefix){
        set = new HashMap<>();
        this.commandPrefix = commandPrefix;
        add(new ListCommand(this), 7);
        this.prefixCount = prefixCount;
        this.suffixCount = suffixCount;
    }

    @Override
    protected void add(CommandBase item)
    {
        add(item, suffixCount);
    }

    private void add(CommandBase item, int suffixCount)
    {
        var result = new StringBuilder(commandList);
        var name = item.getClass().getSimpleName().toLowerCase();
        name = commandPrefix + name.substring(prefixCount, name.length() - suffixCount);
        result.append(String.format("%s\t-\t%s\n",name,item.info ));
        commandList = result.toString();
        set.put(name, item);
    }

    public String getCommandList(){
        return commandList;
    }
}
