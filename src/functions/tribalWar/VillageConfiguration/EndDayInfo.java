package functions.tribalWar.VillageConfiguration;

import core.User;

public class EndDayInfo
{
    public VillageState state;
    private String  info;

    EndDayInfo(VillageState state, String info){
        this.info=info;
        this.state=state;
    }
}
