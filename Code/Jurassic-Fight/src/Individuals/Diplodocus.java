package Individuals;

public abstract class Diplodocus extends Dinosaur {

    private static Race allianceMadeWith;

    public Diplodocus(boolean gender, int energyPoints,String symbol) {
        super(gender, energyPoints,symbol);
    }

    public static Race getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Race race) {
        allianceMadeWith = race;
    }

}