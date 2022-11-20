package Individuals;

import Map.Map;

public abstract class Tyrannosaurus extends Dinosaur {

    private static Alliance allianceMadeWith = Alliance.PterodactylusTyrannosaurus;

    public Tyrannosaurus(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints,map);
    }

    public static Alliance getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Alliance race) {
        allianceMadeWith = race;
    }

}