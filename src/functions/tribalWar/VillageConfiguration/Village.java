package functions.tribalWar.VillageConfiguration;

public class Village
{
    public static final int startVillages = 10;
    private VillageDay day;
    private VillageWorks works;
    private VillagResourses resourses;
    private int freeVill;
    private int vilagesCount;

    public Village(VillageDay day, int vilagesCount)
    {
        this.day = day;
        this.works = new VillageWorks();
        this.resourses = new VillagResourses(VillagResourses.startWood, VillagResourses.startFood);
        this.vilagesCount = vilagesCount;
        this.freeVill = this.vilagesCount;
    }


    public void setDay(VillageDay villageDay)
    {
        this.day = villageDay;
    }

    public synchronized EndDayInfo endDay(VillageDay day)
    {
        resourses.update(this.day, this.works, this);
        vilagesCount += works.getPopulationDelta(this.day, this.freeVill);
        works.reset();
        freeVill = vilagesCount;
        this.day = day;
        var info = getInformation();
        var endDayInfo = new EndDayInfo(VillageState.Lost, info);
        if (resourses.profit >= 1d / 10)
            endDayInfo.state = VillageState.Playing;
        return endDayInfo;
    }

    public void hunt(int countVill)
    {
        freeVill -= works.hunt(freeVill, countVill);
    }

    public void chop(int countVill)
    {
        freeVill -= works.chop(freeVill, countVill);
    }

    int getVillagesCount()
    {
        return vilagesCount;
    }

    public String getInformation()
    {
        String stb = "Today in the village:" +
                System.lineSeparator() +
                day.getInformation() +
                resourses.getInformation() +
                works.getInformation() +
                "Count of villages = " + vilagesCount +
                System.lineSeparator() +
                freeVill + "of them are in base";
        return stb;


    }


}
