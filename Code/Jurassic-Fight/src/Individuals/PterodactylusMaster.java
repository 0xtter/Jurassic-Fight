package Individuals;

import Map.Map;

public class PterodactylusMaster extends Pterodactylus implements Master {

    private static PterodactylusMaster lUnique;

    private PterodactylusMaster(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints, map);
    };

    public static PterodactylusMaster createUnique(boolean genre, int energyPoints, Map map) {
        if (lUnique == null) {
            lUnique = new PterodactylusMaster(genre, energyPoints, map);
        }
        return lUnique;
    }

    public static PterodactylusMaster getInstance() {
        return lUnique;
    }

}