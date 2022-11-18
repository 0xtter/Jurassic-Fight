package individuals;

public abstract class Pterodactylus extends Dinosaur {

    private static Race allianceMadeWith;

    protected Pterodactylus(int energyPoints,String symbol) {
        super(energyPoints,symbol);
    }

    public static Race getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Race race) {
        allianceMadeWith = race;
    }

}