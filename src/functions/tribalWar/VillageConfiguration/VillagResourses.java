package functions.tribalWar.VillageConfiguration;

class VillagResourses
{
    static final int startWood = 10;
    static final int startFood = 10;

    private int wood;
    private int food;
    double profit;

    VillagResourses(int wood, int food)
    {
        this.food = food;
        this.wood = wood;
    }

    void update(VillageDay day, VillageWorks works, Village village)
    {
        wood += works.getChoppers() * day.getChopProfit();
        food += works.getHunters() * day.getHuntProfit();
        var countVill = village.getVillagesCount();
        food -= (countVill / 10) + 1;
        wood -= (countVill / 10) + 1;
        var woodProfit = 1d / wood < 0 ? -1d * countVill/wood  : 1d / 2;
        var foodProfit = 1d / food < 0 ? -1d *  countVill/food  : 1d / 2;
        profit=woodProfit + foodProfit>1?1:woodProfit + foodProfit;
    }

    String getInformation()
    {

        String stb = System.lineSeparator() +
                "Wood count = " + wood +
                System.lineSeparator() +
                "Food count = " + food +
                System.lineSeparator() +
                "profit level is = " + profit +
                System.lineSeparator();
        return stb;
    }
}
