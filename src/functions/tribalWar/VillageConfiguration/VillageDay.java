package functions.tribalWar.VillageConfiguration;

import java.util.Random;

public class VillageDay
{
    private static final int dangerMax = 7;
    private static final int dangerMin = 3;
    private static final int profitMax = 7;
    private static final int profitMin = 3;

    private int huntDanger;
    private int chopDanger;
    private int homeProfit;
    private int huntProfit;
    private int chopProfit;

    private VillageDay(int huntDanger, int chopDanger, int homeDanger, int huntProfit, int chopProfit)
    {
        this.chopDanger = chopDanger;
        this.huntDanger = huntDanger;
        this.homeProfit = homeDanger;
        this.huntProfit = huntProfit;
        this.chopProfit = chopProfit;
    }

    public static VillageDay getNewDay(Random rnd)
    {
        var chopDanger = getRndWithin(dangerMin - 2, dangerMax - 2, rnd);
        var huntDanger = getRndWithin(dangerMin - 1, dangerMax - 1, rnd);
        var homeProfit = getRndWithin(profitMin, profitMax, rnd);
        var huntProfit = getRndWithin(profitMin, profitMax, rnd);
        var chopProfit = getRndWithin(profitMin, profitMax, rnd);
        return new VillageDay(huntDanger, chopDanger, homeProfit, huntProfit, chopProfit);
    }

    private static int getRndWithin(int begin, int end, Random rnd)
    {
        return rnd.nextInt(end - begin) + begin;
    }

    int getChopProfit()
    {
        return chopProfit;
    }

    int getHuntDanger()
    {
        return huntDanger;
    }

    int getChopDanger()
    {
        return chopDanger;
    }


    int getHuntProfit()
    {
        return huntProfit;
    }

    int getHomeProfit()
    {
        return homeProfit;
    }

    String getInformation()
    {
        StringBuilder stb = new StringBuilder();
        if (chopDanger > 5 && huntDanger > 5)
            stb.append("Today is really danger outside the village");
        else
            stb.append("Today is not danger outside the village");

        stb.append(System.lineSeparator());

        if (chopProfit > 4 && huntProfit > 4)
            stb.append("and today is really profitable outside the village");
        else
            stb.append("and today is not profitable outside the village");
        stb.append(System.lineSeparator());
        return stb.toString();
    }
}
