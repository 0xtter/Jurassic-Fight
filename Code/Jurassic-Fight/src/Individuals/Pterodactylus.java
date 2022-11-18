package Individuals;

public abstract class Pterodactylus extends Dinosaur {

    private static Race allianceMadeWith;

    public Pterodactylus(boolean gender, int energyPoints,String symbol) {
        super(gender, energyPoints,symbol);
    }

    public static Race getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Race race) {
        allianceMadeWith = race;
    }

}