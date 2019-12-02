package functions.tribalWar.VillageConfiguration;

class VillageWorks
{
    private int chopVill;
    private int huntVill;

    int hunt(int freeVill, int countVill)
    {
        var countToWork = Math.min(freeVill, countVill);
        huntVill += countToWork;
        return countToWork;

    }

    int chop(int freeVill, int countVill)
    {
        var countToWork = Math.min(freeVill, countVill);
        chopVill += countToWork;
        return countToWork;

    }

    int getChoppers()
    {
        return chopVill;
    }

    int getHunters()
    {
        return huntVill;
    }

    int getPopulationDelta(VillageDay day, int freeVill)
    {
        final int divider=50;
        var huntDeth = huntVill * day.getHuntDanger() / divider;
        var chopDeth = huntVill * day.getChopDanger() / divider;
        var newVill = freeVill * day.getHomeProfit()/ divider;
        return newVill-huntDeth-chopDeth;
    }

    void reset()
    {
        chopVill = 0;
        huntVill = 0;
    }

    String getInformation()
    {
        String stb = System.lineSeparator() +
                "choppers count = " + chopVill +
                System.lineSeparator() +
                "hunters count = " + huntVill +
                System.lineSeparator();
        return stb;
    }
}
