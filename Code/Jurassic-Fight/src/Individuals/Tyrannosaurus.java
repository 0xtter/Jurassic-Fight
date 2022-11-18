package Individuals;

public abstract class Tyrannosaurus extends Dinosaur {

    private static Race allianceMadeWith;

    protected Tyrannosaurus(boolean gender, int energyPoints,String symbol) {
        super(gender, energyPoints,symbol);
    }

    public static Race getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Race race) {
        allianceMadeWith = race;
    }

}