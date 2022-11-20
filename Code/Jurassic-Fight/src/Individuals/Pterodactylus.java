package Individuals;

import Map.Map;

public abstract class Pterodactylus extends Dinosaur {

    private static Alliance allianceMadeWith = Alliance.PterodactylusTyrannosaurus;

    public Pterodactylus(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints, map);
    }

    public static Alliance getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Alliance race) {
        allianceMadeWith = race;
    }

    public void introduiceMyself() {
        System.out.println("I am a Pterodactylus !");
    }

}