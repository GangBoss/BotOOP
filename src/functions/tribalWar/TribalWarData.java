package functions.tribalWar;

import functions.tribalWar.VillageConfiguration.Village;

class TribalWarData
{
    TribalWarState state;
    Village village;


    TribalWarData(Village village, TribalWarState state)
    {
        this.village = village;
        this.state = state;
    }
}
