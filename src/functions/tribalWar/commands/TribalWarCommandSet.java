package functions.tribalWar.commands;

import core.set.CommandSet;

public class TribalWarCommandSet extends CommandSet
{
    public TribalWarCommandSet()
    {
        super(0,"TribalWarCommand".length(),"/");

        add(new ExitTribalWarCommand());
        //add(new SearchTribalWarCommand());
        //add(new SearchingTribalWarCommand());
       // add(new AbandoneTribalWarCommand());
        add(new ChopTribalWarCommand());
        add(new GetInformationTribalWarCommand());
     // add(new AttackTribalWarCommand());
        add(new HuntTribalWarCommand());
       // add(new AllTribalWarCommand());
    }
}
