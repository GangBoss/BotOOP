package functions.tribalWar;

import core.Statable;
import functions.tribalWar.VillageConfiguration.Village;

class TribalWarData implements Statable<TribalWarState>
{
    private TribalWarState state;
    Village village;


    TribalWarData(Village village, TribalWarState state)
    {
        this.village = village;
        this.state = state;
    }

    @Override
    public TribalWarState getState()
    {
        return state;
    }
}
