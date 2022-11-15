package Individuals;

import Map.Map;

public abstract class Tyrannosaurus extends Dinosaur {

    private static Race allianceMadeWith = Race.Pterodactylus;

    public Tyrannosaurus(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints,map);
    }

    public static Race getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Race race) {
        allianceMadeWith = race;
    }

}