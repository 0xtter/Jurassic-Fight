package Individuals;

public abstract class Mosasaurus extends Dinosaur {

    private static Race allianceMadeWith;

    public Mosasaurus(boolean gender, int energyPoints) {
        super(gender, energyPoints);
    }

    public static Race getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Race race) {
        allianceMadeWith = race;
    }

}