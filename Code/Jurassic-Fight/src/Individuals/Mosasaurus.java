package Individuals;

import Map.Map;

public abstract class Mosasaurus extends Dinosaur {

    private static Race allianceMadeWith = Race.Diplodocus;

    public Mosasaurus(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints,map);
    }

    public static Race getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Race race) {
        allianceMadeWith = race;
    }

}