package core.set;

import core.CommandBase;
import data.botCommands.ListCommand;

import java.util.HashMap;
import java.util.HashSet;

public class CommandSet extends BasicSet<String, CommandBase>
{
    private int prefixCount;
    private int suffixCount;
    private String commandPrefix;

    private String commandList = "";

    public CommandSet(int prefixCount, int suffixCount, String commandPrefix){
        set = new HashMap<>();
        this.commandPrefix = commandPrefix;
        this.suffixCount = 7;
        add(new ListCommand(this));
        this.prefixCount = prefixCount;
        this.suffixCount = suffixCount;
    }

    public int getPrefixCount()
    {
        return prefixCount;
    }

    public int getSuffixCount()
    {
        return suffixCount;
    }

    public String getCommandPrefix()
    {
        return commandPrefix;
    }

    @Override
    protected void add(CommandBase item)
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
